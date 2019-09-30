package com.example.lietenerbox.model;

import com.example.lietenerbox.model.dto.request.MemberSignupRequestDto;
import com.example.lietenerbox.model.dto.request.MemberUpdateRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
//회원 엔티티 클래스
@Table(name = "person")
public class Member {
    @Id
    @Column(name = "person_sn")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberSn;

    @Column(nullable = false, length = 20, unique = true)
    private String memberId;//회원 아이디
    private String memberName;//회원 이름

    @JsonIgnore //json 리턴값에서 무시됨
    private String memberPassword;//회원 비밀번호
    private String memberEmail;//회원 이메일
    private boolean memberInfoAgree;//회원 개인정보 동의
    private boolean memberStatus;//회원 상태
    private String memberProfile;//회원 프로필 사진 파일명
    private String memberProfileLoc;//회원 프로필 사진 파일 경로
    private LocalDateTime memberRegisterDate;//회원 가입 날짜

    public boolean matchPassword(String loginPassword) {
        if (loginPassword == null) {
            System.out.println("값이 제대로 안들어옴");
        }
        return loginPassword.equals(memberPassword);
    }

    public Member(MemberSignupRequestDto requestDto) {
        this.memberId = requestDto.getMemberId();
        this.memberPassword = requestDto.getMemberPassword();
        this.memberName = requestDto.getMemberName();
        this.memberEmail = requestDto.getEmail();
    }

    public Member(MemberUpdateRequestDto updateDto) {
        this.memberPassword = memberPassword;
    }
}
