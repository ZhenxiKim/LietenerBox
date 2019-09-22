package com.example.lietenerbox.api;

import com.example.lietenerbox.api.exception.DataDuplicatedException;
import com.example.lietenerbox.model.Member;
import com.example.lietenerbox.model.dto.MemberSignupRequestDto;
import com.example.lietenerbox.model.dto.MemberUpdateRequestDto;
import com.example.lietenerbox.repository.MemberRepository;
import com.example.lietenerbox.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
@Validated
//회원정보 controller
public class MemberApi {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    public MemberApi(MemberRepository memberRepository,
                     MemberService memberService) {
        this.memberRepository = memberRepository;
        this.memberService = memberService;
    }

    //회원 전체 리스트 출력
    @GetMapping("/members")
    public Iterable<Member> memberAll() {
        return memberRepository.findAll();
    }

    //회원 id 정보 출력
    @GetMapping("/members/{id}")
    public Member memberInfo(@PathVariable Long id) {

        return memberRepository.findByMemberSn(id);
    }

    //회원 가입
    @PostMapping("/create")
    public HttpStatus create(@RequestBody MemberSignupRequestDto requestDto) {

        memberRepository.findByMemberId(requestDto.getMemberId())
                .ifPresent(v -> {
                    throw new DataDuplicatedException();
                });

        memberService.signupMember(requestDto);

        return HttpStatus.OK;
    }


    //회원정보수정
    @PutMapping("/{memberSn}")
    public HttpStatus update(@PathVariable Long memberSn, Member updateMem, HttpSession httpSession, @RequestBody MemberUpdateRequestDto updateDto) {

        //이미 로그인한 회원에 대해서 검사?
        // memberRepository.findByMemberId()

        memberService.updateMember(updateDto);
        return HttpStatus.OK;
    }

}
