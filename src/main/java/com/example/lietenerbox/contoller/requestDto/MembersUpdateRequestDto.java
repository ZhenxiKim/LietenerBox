package com.example.lietenerbox.contoller.requestDto;

public class MembersUpdateRequestDto {
    //회원 정보 변경 가능 컬럼
    private String membersPassword;

    public String getmembersPassword() {
        return membersPassword;
    }

    public void setmembersPassword(String membersPassword) {
        this.membersPassword = membersPassword;
    }
}
