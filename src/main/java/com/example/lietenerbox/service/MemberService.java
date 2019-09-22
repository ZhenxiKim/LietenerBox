package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Member;
import com.example.lietenerbox.model.dto.MemberSignupRequestDto;
import com.example.lietenerbox.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void signupMember(MemberSignupRequestDto requestDto) {
        Member member = new Member(requestDto);
        memberRepository.save(member);
    }



}
