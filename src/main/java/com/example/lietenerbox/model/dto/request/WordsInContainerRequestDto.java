package com.example.lietenerbox.model.dto.request;

public class WordsInContainerRequestDto {
    private String containerWordName;
    private String containerWordMean;
    private Integer containerWordLevel;
    private String containerWordPhoto;
    private String containerWordPhotoLoc;

    public String getContainerWordName() {
        return containerWordName;
    }

    public void setContainerWordName(String ContainerWordName) {
        this.containerWordName = ContainerWordName;
    }

    public String getContainerWordMean() {
        return containerWordMean;
    }

    public void setContainerWordMean(String ContainerWordMean) {
        this.containerWordMean = ContainerWordMean;
    }

    public Integer getContainerWordLevel() {
        return containerWordLevel;
    }

    public void setContainerWordLevel(Integer ContainerWordLevel) {
        this.containerWordLevel = ContainerWordLevel;
    }

    public String getContainerWordPhoto() {
        return containerWordPhoto;
    }

    public void setContainerWordPhoto(String ContainerWordPhoto) {
        this.containerWordPhoto = ContainerWordPhoto;
    }

    public String getContainerWordPhotoLoc() {
        return containerWordPhotoLoc;
    }

    public void setContainerWordPhotoLoc(String ContainerWordPhotoLoc) {
        this.containerWordPhotoLoc = ContainerWordPhotoLoc;
    }
}
