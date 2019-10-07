package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.model.Records;
import com.example.lietenerbox.repository.PersonRepository;
import com.example.lietenerbox.repository.RecordsRepository;
import com.example.lietenerbox.repository.WordInGroupRepository;
import com.example.lietenerbox.repository.WordsRepository;
import com.example.lietenerbox.util.DateUtils;
import com.example.lietenerbox.util.StudyLevelUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class StudyWordsService {
    private final PersonRepository personRepository;
    private final WordsRepository wordsRepository;
    private final WordInGroupRepository wordInGroupRepository;
    private final RecordsRepository recordsRepository;

    public StudyWordsService(PersonRepository personRepository, WordsRepository wordsRepository, WordInGroupRepository wordInGroupRepository, RecordsRepository recordsRepository) {
        this.personRepository = personRepository;
        this.wordsRepository = wordsRepository;
        this.wordInGroupRepository = wordInGroupRepository;
        this.recordsRepository = recordsRepository;
    }

    int level1 = 0;
    int level2 = 0;
    int level3 = 0;
    List wordsList = new ArrayList();
    List containerWordsList = new ArrayList();
 /*   studyService
    1.회원이 공부해야할 일차 구하기 : 현재날짜 - 가입날짜
    2.studyLevelUtil에서 공부할 일차 가져오기
    3. wordInGroup,word리파지토리에서 일차에 해당하는 레벨 가져오기
*/

//    public void calDate(Person loginPerson) {
//
//        //로그인한 회원 정보를 토대로 회원이 셋팅한 학습 시작 날짜 가져오기
//        Person savedPerson = personRepository.findByPersonSn(loginPerson.getPersonSn());
//        Records records = recordsRepository.findByPersonOrderByCreatedAtDesc(loginPerson);
//
//        //오늘 학습 차수 = 오늘 날짜 - 회원가입 날짜
//        Long stepDay = DateUtils.calDate(records);
//
//        //오늘 공부해야할 단계 string[]로 반환
//        String[] todayStep = StudyLevelUtils.wordLevel(stepDay);
//
//        wordLevelList(todayStep);
//
//    }

    //차수에 맞는 단어 리스트 가져오기
    public void wordLevelList(String[] todayStep) {

        if (todayStep.length == 1) {
            level1 = Integer.parseInt(todayStep[0]);
            wordsList = wordsRepository.findBywordLevel(level1);
            containerWordsList = wordInGroupRepository.findByGroupWordLevel(level1);
            if(wordsList != null && containerWordsList != null){

            }


        } else if (todayStep.length == 2) {
            level1 = Integer.parseInt(todayStep[0]);
            level2 = Integer.parseInt(todayStep[1]);

        } else {
            level1 = Integer.parseInt(todayStep[0]);
            level2 = Integer.parseInt(todayStep[1]);
            level3 = Integer.parseInt(todayStep[2]);
        }

    }


}
