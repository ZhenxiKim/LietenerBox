package com.example.lietenerbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class GroupWord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long GroupWordId;

    private String GroupWordName;
    private String GroupWordMean;
    private int GroupWordLevel;
    private String GroupWordPhoto;
    private String GroupWordPhotoLocation;

}
