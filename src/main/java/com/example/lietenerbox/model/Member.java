package com.example.lietenerbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long MemberId;

    private String MemberAccount;
    private String MemberName;
    private String MemberPassword;
    private String MemberEmail;
    private boolean MemberInfoAgree;
    private String MemberStatus;
    private String MemberProfile;
    private String MemberProfileLocation;
    private LocalDateTime MemberRegisterDate;


}
