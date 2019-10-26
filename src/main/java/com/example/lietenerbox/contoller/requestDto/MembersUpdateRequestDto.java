package com.example.lietenerbox.contoller.requestDto;

public class MembersUpdateRequestDto {
    //회원 정보 변경 가능 컬럼
    private String personPassword;

    public String getPersonPassword() {
        return personPassword;
    }

    public void setPersonPassword(String personPassword) {
        this.personPassword = personPassword;
    }
}
