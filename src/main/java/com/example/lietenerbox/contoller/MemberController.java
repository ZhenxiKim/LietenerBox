package com.example.lietenerbox.contoller;

import com.example.lietenerbox.api.exception.DataNotFoundException;
import com.example.lietenerbox.model.Member;
import com.example.lietenerbox.repository.ItemsRepository;
import com.example.lietenerbox.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
<<<<<<< HEAD:src/main/java/com/example/lietenerbox/contoller/PersonController.java
@RequestMapping("/persons")
public class PersonController {
=======
@RequestMapping("/members")
public class MemberController {
>>>>>>> parent of 8c5201d... Member엔티티명 Person으로 변경:src/main/java/com/example/lietenerbox/contoller/MemberController.java

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ItemsRepository itemsRepository;

    @GetMapping("")//로그인 성공 시 단어 및 아이템 목록 페이지로 이동
    public String Main(Model model) {
        model.addAttribute("Items", itemsRepository.findAll());
        return "/index";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
<<<<<<< HEAD:src/main/java/com/example/lietenerbox/contoller/PersonController.java
        return "/person/login";
=======
        return "/member/login";
>>>>>>> parent of 8c5201d... Member엔티티명 Person으로 변경:src/main/java/com/example/lietenerbox/contoller/MemberController.java
    }

    //로그인
    @PostMapping("/login")
<<<<<<< HEAD:src/main/java/com/example/lietenerbox/contoller/PersonController.java
    private String login(String personId, String password, HttpSession session) {
        Person person = personRepository.findByPersonId(personId)
=======
    private String login(String memberId, String password, HttpSession session) {
        Member member = memberRepository.findByMemberId(memberId)
>>>>>>> parent of 8c5201d... Member엔티티명 Person으로 변경:src/main/java/com/example/lietenerbox/contoller/MemberController.java
                .orElseThrow(DataNotFoundException::new);

        //Member member = memberRepository.findByMemberId(memberId);
        //멤버 null값 체크
        if (member == null) {
            System.out.println("로그인 실패");
<<<<<<< HEAD:src/main/java/com/example/lietenerbox/contoller/PersonController.java
            return "redirect:/persons/loginForm";
=======
            return "redirect:/members/loginForm";
>>>>>>> parent of 8c5201d... Member엔티티명 Person으로 변경:src/main/java/com/example/lietenerbox/contoller/MemberController.java
        }

        //입력한 비밀번호값과 DB에 저장된 비밀번호 비교. matchPassword 메서드는 데이터를 가지고있는 객체에 생성
        if (!member.matchPassword(password)) {
            System.out.println("로그인 실패");
<<<<<<< HEAD:src/main/java/com/example/lietenerbox/contoller/PersonController.java
            return "redirect:/persons/loginForm";
=======
            return "redirect:/members/loginForm";
>>>>>>> parent of 8c5201d... Member엔티티명 Person으로 변경:src/main/java/com/example/lietenerbox/contoller/MemberController.java
        }

        //DB에 저장된 로그인 정보와 동일 시 session 객체에 로그인 정보 저장
        session.setAttribute("sessionMember",member);

<<<<<<< HEAD:src/main/java/com/example/lietenerbox/contoller/PersonController.java
        return "redirect:/persons";
=======
        return "redirect:/members";
>>>>>>> parent of 8c5201d... Member엔티티명 Person으로 변경:src/main/java/com/example/lietenerbox/contoller/MemberController.java
    }

    //로그아웃 세션에 저장된 로그인 정보 제거
    @GetMapping("/logout")
    public String logout(HttpSession session) {
<<<<<<< HEAD:src/main/java/com/example/lietenerbox/contoller/PersonController.java
        session.removeAttribute("sessionPerson");
        return "redirect:/persons";
=======
        session.removeAttribute("sessionMember");
        return "redirect:/members";
>>>>>>> parent of 8c5201d... Member엔티티명 Person으로 변경:src/main/java/com/example/lietenerbox/contoller/MemberController.java
    }


}
