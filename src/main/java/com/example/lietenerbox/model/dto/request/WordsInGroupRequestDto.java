package com.example.lietenerbox.model.dto.request;

public class WordsInGroupRequestDto {
    private String groupWordName;
    private String groupWordMean;
    private Integer groupWordLevel;
    private String groupWordPhoto;
    private String groupWordPhotoLoc;

    public String getGroupWordName() {
        return groupWordName;
    }

    public void setGroupWordName(String groupWordName) {
        this.groupWordName = groupWordName;
    }

    public String getGroupWordMean() {
        return groupWordMean;
    }

    public void setGroupWordMean(String groupWordMean) {
        this.groupWordMean = groupWordMean;
    }

    public Integer getGroupWordLevel() {
        return groupWordLevel;
    }

    public void setGroupWordLevel(Integer groupWordLevel) {
        this.groupWordLevel = groupWordLevel;
    }

    public String getGroupWordPhoto() {
        return groupWordPhoto;
    }

    public void setGroupWordPhoto(String groupWordPhoto) {
        this.groupWordPhoto = groupWordPhoto;
    }

    public String getGroupWordPhotoLoc() {
        return groupWordPhotoLoc;
    }

    public void setGroupWordPhotoLoc(String groupWordPhotoLoc) {
        this.groupWordPhotoLoc = groupWordPhotoLoc;
    }
}
