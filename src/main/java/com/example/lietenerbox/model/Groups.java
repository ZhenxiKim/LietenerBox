package com.example.lietenerbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="groups")
public class Groups {

    @Id
    @Column(name = "groupId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupId;//그룹 pk 아이디

    private String groupName;//그룹 명
    private LocalDateTime createdAt;//그룹 생성 날짜
    private boolean groupStatus;//그룹 상태(활성/비활성)
    private String groupContents;//그룹 소개 설명

    @ManyToOne
    @JoinColumn(name = "member_memId")
    private Member member; //Member테이블의 memId컬럼 참조

}
