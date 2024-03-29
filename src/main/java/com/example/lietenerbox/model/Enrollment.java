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
@Table(name = "enrollment")
public class Enrollment implements Serializable {

    //복합키로 사용할 컬럼 선언
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long enrollmentId;

    @ManyToOne
    @JoinColumn(name = "members_sn", referencedColumnName = "members_sn")
    private Members members; //members 테이블의 memId컬럼 참조

    @ManyToOne
    @JoinColumn(name = "container_id",referencedColumnName = "container_id")
    private Container container; //goups 테이블과 1:1 단방향 연결

    private LocalDateTime subscribeAt;//구독 시작 날짜
    private boolean subscribeStatus;//구독 상태


    public Enrollment(Members sessionMembers, Container container) {
        this.members = sessionMembers;
        this.container = container;
        this.subscribeAt = LocalDateTime.now();
        this.subscribeStatus = true;
    }
}
