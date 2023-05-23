package com.opensource.hongroaddong.cloud.s3.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record VideoResponseDto(
        @Schema(description = "영상 url", example = "")
        String url,

        @Schema(description = "영상 타임 스탬프", example = "yyyy-MM-dd HH:mm:ss")
        @JsonFormat(
                shape = JsonFormat.Shape.STRING,
                pattern = "yyyy-MM-dd HH:mm:ss",
                locale = "Asia/Seoul"
        )
        LocalDateTime timestamp
) {
}
