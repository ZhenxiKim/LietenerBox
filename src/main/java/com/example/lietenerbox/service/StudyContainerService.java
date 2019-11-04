package com.example.lietenerbox.service;

import com.example.lietenerbox.contoller.requestDto.AnswerForm;
import com.example.lietenerbox.contoller.requestDto.ResultContainerRequestDto;
import com.example.lietenerbox.model.Members;
import com.example.lietenerbox.model.Records;
import com.example.lietenerbox.model.WordInContainer;
import com.example.lietenerbox.repository.MembersRepository;
import com.example.lietenerbox.repository.RecordsRepository;
import com.example.lietenerbox.repository.WordInContainerRepository;
import com.example.lietenerbox.util.DateUtils;
import com.example.lietenerbox.util.HttpSessionUtils;
import com.example.lietenerbox.util.StudyLevelUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

@Service
@Transactional
public class StudyContainerService {
    private final MembersRepository membersRepository;
    private final WordInContainerRepository wordInContainerRepository;
    private final RecordsRepository recordsRepository;

    public StudyContainerService(MembersRepository membersRepository, WordInContainerRepository wordInContainerRepository, RecordsRepository recordsRepository) {
        this.membersRepository = membersRepository;
        this.wordInContainerRepository = wordInContainerRepository;
        this.recordsRepository = recordsRepository;
    }

    int level1 = 0;
    int level2 = 0;
    int level3 = 0;

    List containerWordsList = new ArrayList();


    public void checkLevel(ResultContainerRequestDto reqDto) throws DataFormatException {
        List<AnswerForm> answerFormList = reqDto.getResultList();
        for (int i = 0; i < answerFormList.size(); i++) {

            WordInContainer wordInContainer = wordInContainerRepository.findById(answerFormList.get(i).getContainerWordId()).orElseThrow(DataFormatException::new);

            wordInContainerRepository.save(new WordInContainer(wordInContainer, answerFormList.get(i).isAnswer()));
        }

    }


    public List getStudyWordsInContainers(HttpSession session) throws ParseException {

        //현재 로그인 정보 가져오기
        Members sessionMembers = HttpSessionUtils.getmembersFromSession(session);
        //로그인한 회원 정보를 토대로 회원이 셋팅한 학습 시작 날짜 가져오기
        Records records = recordsRepository.findByMembers(sessionMembers);

        //오늘 학습 차수 = 오늘 날짜 - 회원가입 날짜
        Long stepDay = DateUtils.calDate(records);

        //오늘 공부해야할 단계 string[]로 반환
        String[] todayStep = StudyLevelUtils.wordLevel(stepDay);

        if (todayStep.length == 1) {
            level1 = Integer.parseInt(todayStep[0]);
            containerWordsList = wordInContainerRepository.findByContainerWordLevel(level1);

        } else if (todayStep.length == 2) {
            level1 = Integer.parseInt(todayStep[0]);
            level2 = Integer.parseInt(todayStep[1]);
            containerWordsList = wordInContainerRepository.findByContainerWordLevel(level1);
            containerWordsList.add(wordInContainerRepository.findByContainerWordLevel(level2));

        } else {
            level1 = Integer.parseInt(todayStep[0]);
            level2 = Integer.parseInt(todayStep[1]);
            level3 = Integer.parseInt(todayStep[2]);
            containerWordsList = wordInContainerRepository.findByContainerWordLevel(level1);
            containerWordsList.add(wordInContainerRepository.findByContainerWordLevel(level2));
            containerWordsList.add(wordInContainerRepository.findByContainerWordLevel(level3));

        }
        return containerWordsList;

    }
}
