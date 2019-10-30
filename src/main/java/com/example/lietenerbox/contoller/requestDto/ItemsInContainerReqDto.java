package com.example.lietenerbox.contoller.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemsInContainerReqDto {
    //수정시 생성자 확인
    private Long memSn;
    private Long containerSn;//클래스 시리얼 넘버
    private String itemName;
    private String itemContents;
}
