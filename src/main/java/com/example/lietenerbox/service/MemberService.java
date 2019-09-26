package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Member;
import com.example.lietenerbox.model.dto.request.MemberSignupRequestDto;
import com.example.lietenerbox.model.dto.request.MemberUpdateRequestDto;
import com.example.lietenerbox.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원 가입 메서드
    public void signupMember(MemberSignupRequestDto requestDto) {
        Member member = new Member(requestDto);
        memberRepository.save(member);
    }

    public void updateMember(MemberUpdateRequestDto updateDto) {
        Member member = new Member(updateDto);
        memberRepository.save(member);

    }


}
