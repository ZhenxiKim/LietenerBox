package com.example.lietenerbox.model.dto.request;


public class ContainerRequestDto {
    private String containerName;//그룹 명
    private String containerContents;//그룹 소개 설명

    public String getcontainerName() {
        return containerName;
    }

    public void setcontainerName(String containerName) {
        this.containerName = containerName;
    }

    public String getcontainerContents() {
        return containerContents;
    }

    public void setcontainerContents(String containerContents) {
        this.containerContents = containerContents;
    }
}
