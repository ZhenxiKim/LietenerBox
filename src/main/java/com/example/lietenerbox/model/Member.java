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
    private Long memberId;

    private String memberAccount;
    private String memberName;
    private String memberPassword;
    private String memberEmail;
    private boolean memberInfoAgree;
    private boolean memberStatus;
    private String memberProfile;
    private String memberProfileLocation;
    private LocalDateTime memberRegisterDate;


}
