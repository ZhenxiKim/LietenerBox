package com.example.lietenerbox.model.dto.request;


public class GroupsRequestDto {
    private String groupName;//그룹 명
    private String groupContents;//그룹 소개 설명

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
}
