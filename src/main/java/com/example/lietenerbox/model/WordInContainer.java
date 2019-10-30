package com.example.lietenerbox.model;

import com.example.lietenerbox.contoller.requestDto.WordsInContainerRequestDto;
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


    public WordInContainer(ItemInContainer itemInContainer, String wordName, String wordMean, String wordPhoto, String wordLoc) {
        this.containerWordName = wordName;
        this.containerWordMean = wordMean;
        this.containerWordPhoto = wordPhoto;
        this.containerWordPhotoLoc = wordLoc;
        this.containerWordLevel = 1;
        this.itemInContainer = itemInContainer;
    }
}
