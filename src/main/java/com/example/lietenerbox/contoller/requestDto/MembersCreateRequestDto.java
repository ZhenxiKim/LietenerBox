package com.example.lietenerbox.contoller.requestDto;

public class MembersCreateRequestDto {
    private String membersId;
    private String membersPassword;
    private String membersName;
    private String membersEmail;

    public String getMembersId() {
        return membersId;
    }

    public void setMembersId(String membersId) {
        this.membersId = membersId;
    }

    public String getMembersPassword() {
        return membersPassword;
    }

    public void setMembersPassword(String membersPassword) {
        this.membersPassword = membersPassword;
    }

    public String getMembersName() {
        return membersName;
    }

    public void setMembersName(String membersName) {
        this.membersName = membersName;
    }

    public String getMembersEmail() {
        return membersEmail;
    }

    public void setMembersEmail(String membersEmail) {
        this.membersEmail = membersEmail;
    }
}
