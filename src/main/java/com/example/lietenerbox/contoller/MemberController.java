package com.example.lietenerbox.contoller;

import com.example.lietenerbox.model.Member;
import com.example.lietenerbox.repository.MemberRepository;
import com.example.lietenerbox.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
//회원정보 controller
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    /*어떤 방식이 맞는지?
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/

    private MemberService memberService;

    //회원 전체 리스트
    @GetMapping("/members")
    public Iterable<Member> memberAll(){
        return  memberRepository.findAll();
    }

    //회원 id 정보
    @GetMapping("/member/{id}")
    public Member memberInfo(@PathVariable Long id){
        return memberRepository.findByMemId(id);
    }

    //회원정보수정
    @PutMapping("/{id}")
    public String update(@PathVariable Long id, Member updateMem, HttpSession httpSession){
        //로그인 유저 검사
        return null;
    }

}
