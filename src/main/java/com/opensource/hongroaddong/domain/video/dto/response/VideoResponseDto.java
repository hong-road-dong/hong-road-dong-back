package com.opensource.hongroaddong.domain.video.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.opensource.hongroaddong.domain.video.entity.Video;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record VideoResponseDto(
        @Schema(description = "영상 아이디", example = "1")
        Long videoId,

        @Schema(description = "영상 url", example = "https://hgd-s3-bucket.s3.ap-northeast-2.amazonaws.com/video/test-video_1684823840007.mp4")
        String url,

        @Schema(description = "영상 타임 스탬프", example = "yyyy-MM-dd HH:mm:ss")
        @JsonFormat(
                shape = JsonFormat.Shape.STRING,
                pattern = "yyyy-MM-dd HH:mm:ss",
                locale = "Asia/Seoul"
        )
        LocalDateTime timestamp
) {
        public static VideoResponseDto from(Video video) {
                return VideoResponseDto.builder()
                        .videoId(video.getId())
                        .url(video.getUrl())
                        .timestamp(video.getTimestamp())
                        .build();
        }
}
