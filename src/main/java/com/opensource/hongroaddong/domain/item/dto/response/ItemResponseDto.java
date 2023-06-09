package com.opensource.hongroaddong.domain.item.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.opensource.hongroaddong.domain.item.entity.Item;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ItemResponseDto(

        @Schema(description = "아이템 아이디", example = "1")
        Long itemId,

        @Schema(description = "코멘트", example = "운전 매너가 좋아요")
        String comment,

        @Schema(description = "영상 url", example = "https://hgd-s3-bucket.s3.ap-northeast-2.amazonaws.com/video/test-video_1684823840007.mp4")
        String url,

        @Schema(description = "자동차 번호", example = "12다4567")
        String carNumber,

        @Schema(description = "자동차 번호", example = "12다4567")
        int drivingDegree,

        @JsonFormat(
                shape = JsonFormat.Shape.STRING,
                pattern = "yyyy-MM-dd HH:mm:ss",
                locale = "Asia/Seoul"
        )
        @Schema(description = "등록 일자", example = "2023-06-01 00:00:00")
        LocalDateTime createdAt
) {
    public static ItemResponseDto from(Item item) {
        return ItemResponseDto.builder()
                .itemId(item.getId())
                .comment(item.getComment())
                .url(item.getVideo().getUrl())
                .carNumber(item.getCar().getCarNumber())
                .drivingDegree(item.getDrivingDegree())
                .createdAt(item.getCreatedAt())
                .build();
    }
}
