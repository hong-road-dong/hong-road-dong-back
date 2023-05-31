package com.opensource.hongroaddong.domain.item.dto.response;

import com.opensource.hongroaddong.domain.item.entity.Item;
import lombok.Builder;

@Builder
public record ItemResponseDto(
    Long itemId,
    String comment,
    int drivingDegree
) {
    public static ItemResponseDto from(Item item) {
        return ItemResponseDto.builder()
                .itemId(item.getId())
                .comment(item.getComment())
                .drivingDegree(item.getDrivingDegree())
                .build();
    }
}
