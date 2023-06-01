package com.opensource.hongroaddong.domain.video.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VideoUploadRequestDto {
        @NotNull
        @Schema(description = "사용자 Id", example = "1")
        private Long memberId;

        @NotNull
        @Schema(description = "영상 타임 스탬프")
        private LocalDateTime timestamp;
}
