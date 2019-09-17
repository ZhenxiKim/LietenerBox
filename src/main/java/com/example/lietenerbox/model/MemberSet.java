package com.example.lietenerbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;


    @Data
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    public class MemberSet {
        @Id
        private Long MemberSetId;

        private String MemberSetName;
        private LocalDateTime createdAt;

    }
