package com.example.lietenerbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment implements Serializable {

    //복합키로 사용할 컬럼 선언
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long enrollmentId;

    @OneToOne
    @JoinColumn(name = "member_memId")
    private Member member; //Member테이블의 memId컬럼 참조

    @OneToOne
    @JoinColumn(name = "groups_groupId")
    private Groups groups; //goups테이블과 1:1 단방향 연결


    private LocalDateTime subscribeAt;
    private boolean subscribeStatus;


}
