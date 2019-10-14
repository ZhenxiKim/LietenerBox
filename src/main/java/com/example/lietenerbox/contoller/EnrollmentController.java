package com.example.lietenerbox.contoller;


import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.repository.ContainerRepository;
import com.example.lietenerbox.service.EnrollmentService;
import com.example.lietenerbox.util.HttpSessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/enrollment")
public class EnrollmentController {

    //구독

    private final EnrollmentService enrollmentService;
    private final ContainerRepository containerRepository;

    public EnrollmentController(EnrollmentService enrollmentService, ContainerRepository containerRepository) {
        this.enrollmentService = enrollmentService;
        this.containerRepository = containerRepository;
    }

    @GetMapping()
    public String apply(HttpSession session){
        //그룹 생성 시 로그인 유저 확인
        if (!HttpSessionUtils.isLoginPerson(session)) {
            return "/persons/loginForm";
        }
        return "/enrollment";
    }

    @PostMapping("/{groupId}")
    public String enrollment(@PathVariable Long groupId,HttpSession session){

        //그룹 생성 시 로그인 유저 확인
        if (!HttpSessionUtils.isLoginPerson(session)) {
            return "/persons/loginForm";
        }

        //로그인한 회원의 정보
        Person sessionPerson = HttpSessionUtils.getPersonFromSession(session);



        enrollmentService.apply(sessionPerson,groupId);
        return "a";
    }

}
