package com.example.lietenerbox.model.dto.request;

public class PersonUpdateRequestDto {
    //회원 정보 변경 가능 컬럼
    private String PersonPassword;

    public String getPersonPassword() {
        return PersonPassword;
    }

    public void setPersonPassword(String PersonPassword) {
        this.PersonPassword = PersonPassword;
    }
}
