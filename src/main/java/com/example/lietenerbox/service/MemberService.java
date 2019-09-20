package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Member;
import com.example.lietenerbox.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class MemberService {

    private MemberRepository memberRepository;

//    @Transactional
//    public Long update(Member member){
//        return memberRepository.save(member);
//    }

}
