package com.example.lietenerbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MemberWord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberWordId;
    private String memberWordName;
    private String memberWordMean;
    @Column(nullable=false, columnDefinition = "number(2) default 1")
    private Integer memberWordLevel;
    private String memberWordPhoto;
    private String memberWordPhotoLoc;

}
