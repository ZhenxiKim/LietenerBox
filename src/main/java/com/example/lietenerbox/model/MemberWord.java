package com.example.lietenerbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MemberWord {
    @Id
    private Long MemberWordId;
    private String MemberWordName;
    private String MemberWordMean;
    private int MemberWordLevel;


}
