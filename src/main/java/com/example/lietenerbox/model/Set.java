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
    @Table(name="set")
    public class Set {
        @Id
        @Column(name= "setId")
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long setId;//세트 pk 아이디

        private String setName;//세트 명
        private LocalDateTime setCreatedAt;//세트 생성 날짜

        @ManyToOne
        @JoinColumn(name="member_memId")
        private Member member;//Member테이블의 memId컬럼 참조
    }
