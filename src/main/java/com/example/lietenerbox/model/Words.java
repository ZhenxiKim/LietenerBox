package com.example.lietenerbox.model;

import com.example.lietenerbox.model.dto.request.WordsRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Words {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long wordId;
    private String wordName;
    private String wordMean;

    @Column(nullable = false, columnDefinition = "number(2) default 1")
    private Integer wordLevel;
    private String wordPhoto;
    private String wordPhotoLoc;

    @ManyToOne
    @JoinColumn(name = "item_itemId")
    private Items items;

    public Words(WordsRequestDto wordsRequestDto, Items items) {
        this.wordName = wordsRequestDto.getWordName();
        this.wordLevel = 1;
        this.wordMean = wordsRequestDto.getWordMean();
        this.wordPhoto = wordsRequestDto.getWordPhoto();
        this.wordPhotoLoc = wordsRequestDto.getWordPhotoLoc();
        this.items = items;
    }
}
