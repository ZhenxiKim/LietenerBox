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
public class WordInGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupWordId;

    private String groupWordName;
    private String groupWordMean;
    @Column(nullable = false, columnDefinition = "number(2) default 1")
    private Integer groupWordLevel;
    private String groupWordPhoto;
    private String groupWordPhotoLoc;

    @ManyToOne
    @JoinColumn(name = "itemInGroup_groupItemId")
    private ItemInGroup itemInGroup;

    public WordInGroup(WordsRequestDto wordsRequestDto, ItemInGroup itemInGroup) {
        this.groupWordName = wordsRequestDto.getGroupWordName();
        this.groupWordMean = wordsRequestDto.getGroupWordMean();
        this.groupWordPhoto = wordsRequestDto.getGroupWordPhoto();
        this.groupWordPhotoLoc = wordsRequestDto.getGroupWordPhotoLoc();
        this.itemInGroup = itemInGroup;
    }
}
