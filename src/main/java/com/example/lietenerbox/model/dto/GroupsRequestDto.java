package com.example.lietenerbox.model.dto;

import java.time.LocalDateTime;

public class GroupsRequestDto {
    private String groupName;//그룹 명
    private LocalDateTime createdAt;//그룹 생성 날짜
    private String groupContents;//그룹 소개 설명

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getGroupContents() {
        return groupContents;
    }

    public void setGroupContents(String groupContents) {
        this.groupContents = groupContents;
    }
}
