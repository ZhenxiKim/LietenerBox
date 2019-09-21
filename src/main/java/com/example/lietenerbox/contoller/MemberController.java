package com.example.lietenerbox.contoller;

import com.example.lietenerbox.model.Member;
import com.example.lietenerbox.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/loginForm")
    public String loginForm(){
        return "/member/login";
    }

    @PostMapping("/login")
    private String login(String memberId, String password, HttpSession session) {
        Member member = memberRepository.findByMemberId(memberId);

        if (memberId == null) {
            System.out.println("로그인 실패");
            //return "redirect:/"
        }
        if (member.matchPassword(password)) {
            System.out.println("로그인 성공");
        }
        session.setAttribute("sessionMember",member);
        return "redirect:/members";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("sessionMember");
        return "로그아웃";
    }



}
