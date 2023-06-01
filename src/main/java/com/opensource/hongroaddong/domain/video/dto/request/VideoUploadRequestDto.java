package com.opensource.hongroaddong.domain.video.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Validated
@ParameterObject
public class VideoUploadRequestDto {
        @Schema(description = "사용자 Id", example = "1")
        private Long memberId;

        @Schema(description = "영상 타임 스탬프")
        private LocalDateTime timestamp;
}
