package com.example.lietenerbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    @JoinColumn(name = "person_sn", referencedColumnName = "person_sn", nullable = false)
    private Person person;//Person 테이블의 personSn 컬럼 참조

    public Records(Person loginPerson, String studySetDate) {
        this.studyDay = studySetDate;
        this.person = loginPerson;
    }
}
