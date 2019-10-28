package com.example.lietenerbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "records")
@AllArgsConstructor
@NoArgsConstructor
public class Records {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recordsId;
    private String studyDay;//학습모드 시작 날짜 입력 스트링으로 받고 dateutil클래스에서 날짜 형식 변경

    @ManyToOne
    @JoinColumn(name = "members_sn", referencedColumnName = "members_sn", nullable = false)
    private Members members;//members 테이블의 membersSn 컬럼 참조

    public Records(Members loginMembers, String studySetDate) {
        this.studyDay = studySetDate;
        this.members = loginMembers;
    }
}
