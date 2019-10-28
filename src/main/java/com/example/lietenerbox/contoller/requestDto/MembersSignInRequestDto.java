package com.example.lietenerbox.contoller.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MembersSignInRequestDto {
    private String memId;
    private String memPwd;
}
