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

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/members")
public class MemberController {

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
        return "/member/login";
    }

    //로그인
    @PostMapping("/login")
    private String login(String memberId, String password, HttpSession session) {
        Member member = memberRepository.findByMemberId(memberId)
                .orElseThrow(DataNotFoundException::new);

        //멤버아이디 null값 체크
        if (memberId == null) {
            System.out.println("로그인 실패");
            return "redirect:/members/loginForm";
        }

        //입력한 비밀번호값과 DB에 저장된 비밀번호 비교. matchPassword 메서드는 데이터를 가지고있는 객체에 생성
        if (!member.matchPassword(password)) {
            System.out.println("로그인 실패");
            return "redirect:/members/loginForm";
        }

        //DB에 저장된 로그인 정보와 동일 시 session 객체에 로그인 정보 저장
        session.setAttribute("sessionMember",member);
        return "redirect:/members";
    }

    //로그아웃 세션에 저장된 로그인 정보 제거
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("sessionMember");
        return "redirect:/members";
    }


}
