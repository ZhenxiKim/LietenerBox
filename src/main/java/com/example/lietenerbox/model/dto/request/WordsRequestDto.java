package com.example.lietenerbox.model.dto.request;

import javax.persistence.Column;

public class WordsRequestDto {

    private String wordName;
    private String wordMean;
    private Integer wordLevel;
    private String wordPhoto;
    private String wordPhotoLoc;

    public String getWordName() {
        return wordName;
    }

    public void setWordName(String wordName) {
        this.wordName = wordName;
    }

    public String getWordMean() {
        return wordMean;
    }

    public void setWordMean(String wordMean) {
        this.wordMean = wordMean;
    }

    public Integer getWordLevel() {
        return wordLevel;
    }

    public void setWordLevel(Integer wordLevel) {
        this.wordLevel = wordLevel;
    }

    public String getWordPhoto() {
        return wordPhoto;
    }

    public void setWordPhoto(String wordPhoto) {
        this.wordPhoto = wordPhoto;
    }

    public String getWordPhotoLoc() {
        return wordPhotoLoc;
    }

    public void setWordPhotoLoc(String wordPhotoLoc) {
        this.wordPhotoLoc = wordPhotoLoc;
    }
}
