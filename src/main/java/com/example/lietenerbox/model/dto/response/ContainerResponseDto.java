package com.example.lietenerbox.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContainerResponseDto {
    private Long memSn; // 생성자
    private String containerName;//그룹 명
    private String containerContents;//그룹 소개 설명
    private LocalDateTime createdAt;//그룹 생성 날짜
    private boolean containerStatus;//그룹 상태(활성/비활성)


}
