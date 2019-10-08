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
@Table(name = "words")
public class Words {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long wordId;
    private String wordName;
    private String wordMean;
    private Integer wordLevel = 1;
    private String wordPhoto;
    private String wordPhotoLoc;

    @ManyToOne
    @JoinColumn(name = "itemId", referencedColumnName = "itemId", nullable = false)
    private Items items;

    public Words(WordsRequestDto wordsRequestDto, Items items) {
        this.wordName = wordsRequestDto.getWordName();
        this.wordLevel = 1;
        this.wordMean = wordsRequestDto.getWordMean();
        this.wordPhoto = wordsRequestDto.getWordPhoto();
        this.wordPhotoLoc = wordsRequestDto.getWordPhotoLoc();
        this.items = items;
    }

    public Words(String wordName, String wordMean, Items items) {
        this.wordName = wordName;
        this.wordMean = wordMean;
        this.items = items;
    }

    public Words(String right, String wrong) {
        if(right != null){
            this.wordLevel++;
        }
        if(wrong != null){
            this.wordLevel = 1;
        }
    }
}
