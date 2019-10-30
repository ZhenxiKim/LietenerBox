package com.example.lietenerbox.contoller.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContainerChangeReqDto {

    //TODO 토큰 실어 보내기
    private Long memSn;
    private Long ContainerSn;
    private String containerName;//그룹 명
    private String containerContents;//그룹 소개 설명


}


