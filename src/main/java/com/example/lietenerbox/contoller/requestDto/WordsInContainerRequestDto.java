package com.example.lietenerbox.contoller.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordsInContainerRequestDto {

    private Long itemSn;//소속된 세트 아이디
    private List<WordsListForm> listWords;

}
