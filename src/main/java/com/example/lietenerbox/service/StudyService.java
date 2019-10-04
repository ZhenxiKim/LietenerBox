package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.repository.PersonRepository;
import com.example.lietenerbox.repository.WordInGroupRepository;
import com.example.lietenerbox.repository.WordsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Service
@Transactional
public class StudyService {
    private final PersonRepository personRepository;
    private final WordsRepository wordsRepository;
    private final WordInGroupRepository wordInGroupRepository;

    public StudyService(PersonRepository personRepository, WordsRepository wordsRepository, WordInGroupRepository wordInGroupRepository) {
        this.personRepository = personRepository;
        this.wordsRepository = wordsRepository;
        this.wordInGroupRepository = wordInGroupRepository;
    }

 /*   studyService
    1.회원이 공부해야할 일차 구하기 : 현재날짜 - 가입날짜
    2.studyLevelUtil에서 공부할 일차 가져오기
    3. wordInGroup,word리파지토리에서 일차에 해당하는 레벨 가져오기
*/

    public Long calDate(Person loginPerson){

        //로그인한 회원 정보를 토대로 회원가입 날짜 가져오기
        Person savedPerson = personRepository.findByPersonSn(loginPerson.getPersonSn());

        String regDate = String.valueOf(savedPerson.getPersonRegisterDate());
        String nowDate = String.valueOf(LocalDateTime.now());
        Long studyDate = 0L;
        try {

            //String 타입으로 date타입으로 캐스팅 하면서 생기는 예외로 인해 여기서 예외처리 하지 않으면 컴파일 오류가 남.
            SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
            Date regDate1 = format.parse(regDate);
            Date nowDate1 = format.parse(nowDate);

            Long calDate = regDate1.getTime() - nowDate1.getTime();
            //일수구하기
            studyDate = calDate / (24 * 60 * 60 * 1000);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return studyDate;
    }


}
