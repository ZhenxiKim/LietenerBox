package com.example.lietenerbox.contoller;

import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.repository.PersonRepository;
import com.example.lietenerbox.service.StudyService;
import com.example.lietenerbox.util.HttpSessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/study")
public class StudyController {

    private final PersonRepository personRepository;
    private final StudyService studyService;

    public StudyController(PersonRepository personRepository, StudyService studyService) {
        this.personRepository = personRepository;
        this.studyService = studyService;
    }

    //학습할 날짜 회원 직접 설정 후 학습 페이지로 이동
    @GetMapping()
    public String studyMode(HttpSession session, Model model) {

        if (!HttpSessionUtils.isLoginPerson(session)) {
            return "/persons/loginForm";
        }

        return "/study/studySetting";
    }

    //회원이설정한 학습모드일자 입력
    @PostMapping("")
    public String setStudyDate(HttpSession session, String studySetDate) {

        if (!HttpSessionUtils.isLoginPerson(session)) {
            return "/persons/loginForm";
        }

        //로그인 회원 정보
        Person loginPerson = HttpSessionUtils.getPersonFromSession(session);
        studyService.setStudyDate(loginPerson, studySetDate);
        return "/study/studyMain";
    }

    //회원의 학습 단계와 학습해야할 단어 출력
    @GetMapping("/studyMain")
    public String studyMode(HttpSession session,Model model) {
        if (!HttpSessionUtils.isLoginPerson(session)) {
            return "/persons/loginForm";
        }

        //로그인 회원 정보
        Person loginPerson = HttpSessionUtils.getPersonFromSession(session);

        if (loginPerson != null) {
            //날짜 계산
            model.addAttribute("studyLevel", studyService.calDate(loginPerson));
        }
    }

}