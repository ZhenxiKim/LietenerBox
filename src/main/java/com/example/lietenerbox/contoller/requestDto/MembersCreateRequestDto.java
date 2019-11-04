package com.example.lietenerbox.contoller.requestDto;

import javax.validation.constraints.NotBlank;

public class MembersCreateRequestDto {
    @NotBlank
    private String membersId;
    @NotBlank
    private String membersPassword;
    @NotBlank
    private String membersName;
    @NotBlank
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
