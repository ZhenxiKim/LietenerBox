package com.example.lietenerbox.model;

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
@Table(name="member")
public class Member {
    @Id
    @Column(name="memId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memId;

    @Column(nullable = false, length=20, unique = true)
    private String memAccount;//회원 아이디
    private String memName;//회원 이름

    @JsonIgnore //json 리턴값에서 무시됨
    private String memPassword;//회원 비밀번호
    private String memEmail;//회원 이메일
    private boolean memInfoAgree;//회원 개인정보 동의
    private boolean memStatus;//회원 상태
    private String memProfile;//회원 프로필 사진 파일명
    private String memProfileLoc;//회원 프로필 사진 파일 경로
    private LocalDateTime memRegisterDate;//회원 가입 날짜


}
