package com.example.lietenerbox.model.dto.response;

import java.time.LocalDateTime;


public class ContainerResponseDto {
    private String containerName;//그룹 명
    private String containerContents;//그룹 소개 설명
    private LocalDateTime createdAt;//그룹 생성 날짜
    private boolean containerStatus;//그룹 상태(활성/비활성)

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean iscontainerStatus() {
        return containerStatus;
    }

    public void setcontainerStatus(boolean containerStatus) {
        this.containerStatus = containerStatus;
    }
}
