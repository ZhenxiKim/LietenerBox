package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.model.Records;
import com.example.lietenerbox.repository.PersonRepository;
import com.example.lietenerbox.repository.RecordsRepository;
import com.example.lietenerbox.repository.WordInContainerRepository;
import com.example.lietenerbox.repository.WordsRepository;
import com.example.lietenerbox.util.DateUtils;
import com.example.lietenerbox.util.StudyLevelUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;

@Service
@Transactional
public class SettingStudyService {
    private final PersonRepository personRepository;
    private final WordsRepository wordsRepository;
    private final WordInContainerRepository wordInContainerRepository;
    private final RecordsRepository recordsRepository;


    public SettingStudyService(PersonRepository personRepository, WordsRepository wordsRepository, WordInContainerRepository wordInContainerRepository, RecordsRepository recordsRepository) {
        this.personRepository = personRepository;
        this.wordsRepository = wordsRepository;
        this.wordInContainerRepository = wordInContainerRepository;
        this.recordsRepository = recordsRepository;
    }

    //회원이 입력한 학습 모드날짜 db 입력
    public void setStudyDate(Person loginPerson, String studySetDate) {
        recordsRepository.save(new Records(loginPerson, studySetDate));
    }

    //설정한 학습날짜를 기반으로 오늘 공부해야할 단계 가져오기
    public String[] gettingDate(Person loginPerson) throws ParseException {

        //로그인한 회원 정보를 토대로 회원이 셋팅한 학습 시작 날짜 가져오기
        Records records = recordsRepository.findAllByPerson(loginPerson);

        //오늘 학습 차수 = 오늘 날짜 - 회원가입 날짜
        Long stepDay = DateUtils.calDate(records);

        //오늘 공부해야할 단계 string[]로 반환
        String[] todayStep = StudyLevelUtils.wordLevel(stepDay);

        return todayStep;

    }


}
