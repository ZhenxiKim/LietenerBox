package com.example.lietenerbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long wordId;
    private String wordName;
    private String wordMean;

    @Column(nullable=false, columnDefinition = "number(2) default 1")
    private Integer wordLevel;
    private String wordPhoto;
    private String wordPhotoLoc;

    @ManyToOne
    @JoinColumn(name="set_setId")
    private Set set;

}
