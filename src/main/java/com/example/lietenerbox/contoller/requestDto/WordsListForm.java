package com.example.lietenerbox.contoller.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WordsListForm {
    private String wordName;
    private String wordMean;
    private String photoName;
    private String photoLoc;

}
