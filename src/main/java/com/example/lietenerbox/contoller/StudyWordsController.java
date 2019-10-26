package com.example.lietenerbox.contoller;

import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.model.Records;
import com.example.lietenerbox.repository.RecordsRepository;
import com.example.lietenerbox.service.StudyWordsService;
import com.example.lietenerbox.util.DateUtils;
import com.example.lietenerbox.util.HttpSessionUtils;
import com.example.lietenerbox.util.StudyLevelUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.ParseException;

@Controller
@RequestMapping("/studyWords")
public class StudyWordsController {


    private final StudyWordsService studyWordsService;
    private final RecordsRepository recordsRepository;

    public StudyWordsController(StudyWordsService studyWordsService, RecordsRepository recordsRepository) {

        this.studyWordsService = studyWordsService;

        this.recordsRepository = recordsRepository;
    }

    //회원의 학습 단계와 학습해야할 단어 출력
    @GetMapping("/studyMain")
    public String gettingDate(Person loginPerson, HttpSession session, Model model) throws ParseException {

        //그룹 생성 시 로그인 유저 확인
        if (!HttpSessionUtils.isLoginPerson(session)) {
            return "/persons/loginForm";
        }
        //로그인한 회원의 정보
        Person sessionPerson = HttpSessionUtils.getPersonFromSession(session);

        //로그인한 회원 정보를 토대로 회원이 셋팅한 학습 시작 날짜 가져오기
        Records records = recordsRepository.findAllByPerson(sessionPerson);

        //오늘 학습 차수 = 오늘 날짜 - 회원가입 날짜
        Long stepDay = DateUtils.calDate(records);

        //오늘 공부해야할 단계 string[]로 반환
        String[] todayStep = StudyLevelUtils.wordLevel(stepDay);

        model.addAttribute("studyWords", studyWordsService.wordLevelList(todayStep));

        return "study/wordsStudy";

    }

    @PostMapping("")
    public void levelTest(String right, String wrong) {
        studyWordsService.checkLevel(right, wrong);
    }

}