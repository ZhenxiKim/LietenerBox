package com.example.lietenerbox.model;

import com.example.lietenerbox.model.dto.request.WordsInGroupRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wordInGroup")
public class WordInGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupWordId;

    private String groupWordName;
    private String groupWordMean;
    private Integer groupWordLevel = 1;
    private String groupWordPhoto;
    private String groupWordPhotoLoc;

    @ManyToOne
    @JoinColumn(name = "itemInGroup", referencedColumnName = "groupItemId", nullable = false)
    private ItemInGroup itemInGroup;

    public WordInGroup(WordsInGroupRequestDto wordsInGroupRequestDto, ItemInGroup itemInGroup) {
        this.groupWordName = wordsInGroupRequestDto.getGroupWordName();
        this.groupWordMean = wordsInGroupRequestDto.getGroupWordMean();
        this.groupWordPhoto = wordsInGroupRequestDto.getGroupWordPhoto();
        this.groupWordPhotoLoc = wordsInGroupRequestDto.getGroupWordPhotoLoc();
        this.groupWordLevel = 1;
        this.itemInGroup = itemInGroup;
    }


    public WordInGroup(ItemInGroup itemInGroup, String wordName, String wordMean) {
        this.groupWordName = wordName;
        this.groupWordMean = wordMean;
        this.itemInGroup = itemInGroup;
    }

    public WordInGroup(String right, String wrong) {
        if(right != null){
            this.groupWordLevel++;
        }
        if(wrong != null){
            this.groupWordLevel = 1;
        }
    }
}
