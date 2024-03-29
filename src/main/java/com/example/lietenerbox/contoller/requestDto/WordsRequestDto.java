package com.example.lietenerbox.contoller.requestDto;

import com.example.lietenerbox.model.Words;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordsRequestDto {
    private Long folderSn;
    private List<WordsListForm> wordsList;
}
