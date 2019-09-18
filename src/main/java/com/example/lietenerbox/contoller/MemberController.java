package com.example.lietenerbox.contoller;

import com.example.lietenerbox.model.Member;
import com.example.lietenerbox.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/{id}")
    public Member memberinfo(@PathVariable Long id){
        return memberRepository.findByMemberId(id);
    }
}
