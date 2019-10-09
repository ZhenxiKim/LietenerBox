package com.example.lietenerbox.model;

import com.example.lietenerbox.model.dto.request.PersonSignupRequestDto;
import com.example.lietenerbox.model.dto.request.PersonUpdateRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
//회원 엔티티 클래스
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "person_sn")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long personSn;

    @Column(nullable = false, length = 20, unique = true)
    private String personId;//회원 아이디
    private String personName;//회원 이름
    private Enum roleCode;

    @JsonIgnore //json 리턴값에서 무시됨
    private String personPassword;//회원 비밀번호
    private String personEmail;//회원 이메일
    private boolean personInfoAgree;//회원 개인정보 동의
    private boolean personStatus;//회원 상태
    private String personProfile;//회원 프로필 사진 파일명
    private String personProfileLoc;//회원 프로필 사진 파일 경로
    private LocalDateTime PersonRegisterDate;//회원 가입 날짜

    @OneToMany
    @JoinColumn(name="records")
    private List<Records> records;

    public boolean matchPassword(String loginPassword) {
        if (loginPassword == null) {
            System.out.println("값이 제대로 안들어옴");
        }
        return loginPassword.equals(personPassword);
    }

    public Person(PersonSignupRequestDto requestDto) {
        this.personId = requestDto.getPersonId();
        this.personPassword = requestDto.getPersonPassword();
        this.personName = requestDto.getPersonName();
        this.personEmail = requestDto.getPersonEmail();
    }

    public Person(PersonUpdateRequestDto updateDto) {
        this.personPassword = personPassword;
    }
}
