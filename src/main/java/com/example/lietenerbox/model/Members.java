package com.example.lietenerbox.model;

import com.example.lietenerbox.contoller.requestDto.MembersCreateRequestDto;
import com.example.lietenerbox.contoller.requestDto.MembersUpdateRequestDto;
import com.example.lietenerbox.contoller.requestDto.UpdateMemberInfoRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
//회원 엔티티 클래스
@Table(name = "members")
public class Members {
    @Id
    @Column(name = "members_sn")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long membersSn;

    @Column(nullable = false, length = 20, unique = true)
    private String membersId;//회원 아이디
    private String membersName;//회원 이름
    private Enum roleCode;

    @JsonIgnore //json 리턴값에서 무시됨
    private String membersPassword;//회원 비밀번호
    private String membersEmail;//회원 이메일
    private boolean membersInfoAgree;//회원 개인정보 동의
    private boolean membersStatus;//회원 상태
    private String membersProfile;//회원 프로필 사진 파일명
    private String membersProfileLoc;//회원 프로필 사진 파일 경로
    private LocalDateTime membersRegisterDate;//회원 가입 날짜

    @OneToMany
    @JoinColumn(name = "records")
    private List<Records> records;

    public Members(String memEmail, String memId, String memName, String memPwd) {
        this.membersEmail = memEmail;
        this.membersId = memId;
        this.membersInfoAgree = true;
        this.membersName = memName;
        this.membersPassword = memPwd;
    }



    public boolean matchPassword(String loginPassword) {
        if (loginPassword == null) {
            System.out.println("값이 제대로 안들어옴");
        }
        return loginPassword.equals(membersPassword);
    }

    public Members(MembersCreateRequestDto requestDto) {
        this.membersId = requestDto.getMembersId();
        this.membersPassword = requestDto.getMembersPassword();
        this.membersName = requestDto.getMembersName();
        this.membersEmail = requestDto.getMembersEmail();
    }

}
