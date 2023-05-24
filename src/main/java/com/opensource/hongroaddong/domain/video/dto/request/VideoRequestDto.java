package com.opensource.hongroaddong.domain.video.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Validated
@ParameterObject
public class VideoRequestDto {
        @Schema(description = "영상 타임 스탬프")
        private LocalDateTime timestamp;
}
