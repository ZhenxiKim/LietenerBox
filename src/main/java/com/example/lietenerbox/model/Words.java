package com.example.lietenerbox.model;

import com.example.lietenerbox.contoller.requestDto.ChangeWordsListForm;
import com.example.lietenerbox.contoller.requestDto.WordsListForm;
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
    private Folders folders;

    public Words(String wordName, String wordMean, Folders folders) {
        this.wordName = wordName;
        this.wordMean = wordMean;
        this.folders = folders;
    }

    public Words(String right, String wrong) {
        if (right != null) {
            this.wordLevel++;
        }
        if (wrong != null) {
            this.wordLevel = 1;
        }
    }

    public Words(Folders folders, WordsListForm newWords) {
        this.wordName = newWords.getWordName();
        this.wordLevel = 1;
        this.wordMean = newWords.getWordMean();
        this.wordPhoto = newWords.getPhotoName();
        this.wordPhotoLoc = newWords.getPhotoLoc();
        this.folders = folders;
    }

    public Words(Folders folders, ChangeWordsListForm words) {
        this.wordName = words.getWordName();
        this.wordMean = words.getWordMean();
        this.wordPhoto = words.getPhotoName();
        this.wordPhotoLoc = words.getPhotoLoc();
        this.folders = folders;
    }
}
