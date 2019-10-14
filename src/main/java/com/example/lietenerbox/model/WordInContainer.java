package com.example.lietenerbox.model;

import com.example.lietenerbox.model.dto.request.WordsInContainerRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wordInContainer")
public class WordInContainer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long containerWordId;

    private String containerWordName;
    private String containerWordMean;
    private Integer containerWordLevel = 1;
    private String containerWordPhoto;
    private String containerWordPhotoLoc;

    @ManyToOne
    @JoinColumn(name = "itemInContainer", referencedColumnName = "containerItemId", nullable = false)
    private ItemInContainer itemInContainer;

    public WordInContainer(WordsInContainerRequestDto wordsIncontainerRequestDto, ItemInContainer itemInContainer) {
        this.containerWordName = wordsIncontainerRequestDto.getContainerWordName();
        this.containerWordMean = wordsIncontainerRequestDto.getContainerWordMean();
        this.containerWordPhoto = wordsIncontainerRequestDto.getContainerWordPhoto();
        this.containerWordPhotoLoc = wordsIncontainerRequestDto.getContainerWordPhotoLoc();
        this.containerWordLevel = 1;
        this.itemInContainer = itemInContainer;
    }


    public WordInContainer(ItemInContainer itemInContainer, String wordName, String wordMean) {
        this.containerWordName = wordName;
        this.containerWordMean = wordMean;
        this.itemInContainer = itemInContainer;
    }

    public WordInContainer(String right, String wrong) {
        if(right != null){
            this.containerWordLevel++;
        }
        if(wrong != null){
            this.containerWordLevel = 1;
        }
    }
}
