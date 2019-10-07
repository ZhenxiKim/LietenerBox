package com.example.lietenerbox.contoller;

import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.repository.PersonRepository;
import com.example.lietenerbox.service.SettingStudyService;
import com.example.lietenerbox.service.StudyWordsService;
import com.example.lietenerbox.util.HttpSessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/setting")
public class SettingStudyController {
    //스터디 설정 controller
    private final PersonRepository personRepository;
    private final StudyWordsService studyService;
    private final SettingStudyService settingStudyService;

    public SettingStudyController(PersonRepository personRepository, StudyWordsService studyService,SettingStudyService settingStudyService) {
        this.personRepository = personRepository;
        this.studyService = studyService;
        this.settingStudyService = settingStudyService;
    }

    //학습할 날짜 회원 직접 설정 후 학습 페이지로 이동
    @GetMapping()
    public String setting(HttpSession session, Model model) {

        if (!HttpSessionUtils.isLoginPerson(session)) {
            return "/persons/loginForm";
        }
        //날짜를 설정할 studySetting 페이지로 이동
        return "/study/studySetting";
    }

    //studySetting 페이지에서 회원이설정한 학습모드일자 입력
    @PostMapping("")
    public String setStudyDate(HttpSession session, String studySetDate) {

        if (!HttpSessionUtils.isLoginPerson(session)) {
            return "/persons/loginForm";
        }

        //로그인 회원 정보
        Person loginPerson = HttpSessionUtils.getPersonFromSession(session);
        //사용자가 입력한 날짜 설정
        settingStudyService.setStudyDate(loginPerson, studySetDate);
        return "/study/studyMain";
    }

    @GetMapping("/studyMain")
    public String getLevel(HttpSession session,Model model) throws ParseException {
        if (!HttpSessionUtils.isLoginPerson(session)) {
            return "/persons/loginForm";
        }

        //로그인 회원 정보
        Person loginPerson = HttpSessionUtils.getPersonFromSession(session);
        //사용자가 입력한 날짜 설정
        model.addAttribute("setDate",settingStudyService.gettingDate(loginPerson));
        return "/study/studyMain";
    }

}
