package com.example.lietenerbox.model.dto.response;

import com.example.lietenerbox.contoller.requestDto.WordsListForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordsInItemResDto {

    private Long itemSn;
    private List<WordsListForm> wordsList;
}
