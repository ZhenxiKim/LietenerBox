package com.example.lietenerbox.contoller.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeWordsListForm {
    private String wordName;
    private String wordMean;
    private String photoName;
    private String photoLoc;
}
