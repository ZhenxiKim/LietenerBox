package com.example.lietenerbox.contoller.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultContainerRequestDto {
    //TODo 회원 값이 필요한지 확인
    private Long membersSn;
    private List<AnswerForm> resultList;

}
