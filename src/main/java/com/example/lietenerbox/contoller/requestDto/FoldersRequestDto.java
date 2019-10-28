package com.example.lietenerbox.contoller.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoldersRequestDto {
    private Long memSn;
    private String folderName;
}
