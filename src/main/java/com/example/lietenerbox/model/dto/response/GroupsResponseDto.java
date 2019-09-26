package com.example.lietenerbox.model.dto.response;

import lombok.Data;

import java.time.LocalDateTime;


public class GroupsResponseDto {
    private String groupName;//그룹 명
    private String groupContents;//그룹 소개 설명
    private LocalDateTime createdAt;//그룹 생성 날짜
    private boolean groupStatus;//그룹 상태(활성/비활성)

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupContents() {
        return groupContents;
    }

    public void setGroupContents(String groupContents) {
        this.groupContents = groupContents;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(boolean groupStatus) {
        this.groupStatus = groupStatus;
    }
}
