package com.example.lietenerbox.contoller;

import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.repository.PersonRepository;
import com.example.lietenerbox.service.StudyService;
import com.example.lietenerbox.util.HttpSessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
@RestController("/study")
public class StudyController {

    private final PersonRepository personRepository;
    private final StudyService studyService;

    public StudyController(PersonRepository personRepository, StudyService studyService) {
        this.personRepository = personRepository;
        this.studyService = studyService;
    }

    //회원이 오늘 공부해야할 차수와
    @GetMapping("/studyMode")
    public String studyMode(HttpSession session, Model model) {

        if (!HttpSessionUtils.isLoginPerson(session)) {
            return "/persons/loginForm";
        }

        //로그인 회원 정보
        Person loginPerson = (Person) session.getAttribute("person");

        model.addAttribute("studyLevel",studyService.calDate(loginPerson));
        return "/study/studyMode";
    }
}