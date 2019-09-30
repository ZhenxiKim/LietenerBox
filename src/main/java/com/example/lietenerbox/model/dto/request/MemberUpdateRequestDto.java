package com.example.lietenerbox.model.dto.request;

public class MemberUpdateRequestDto {
    //회원 정보 변경 가능 컬럼
    private String memberPassword;

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }
}
