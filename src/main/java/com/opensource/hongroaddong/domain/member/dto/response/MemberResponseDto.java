package com.opensource.hongroaddong.domain.member.dto.response;

import com.opensource.hongroaddong.domain.item.dto.response.ItemResponseDto;
import com.opensource.hongroaddong.domain.member.entity.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.List;

@Builder
public record MemberResponseDto(
        @Schema(description = "사용자 프로필 이미지", example = "./image")
        String profileImage,

        @Schema(description = "사용자 닉네암", example = "HGD")
        String nickname,

        @Schema(description = "운전 지수", example = "88.8")
        Double drivingDegree,

        @Schema(description = "피드백 리스트")
        List<ItemResponseDto> items
) {
    public static MemberResponseDto from(Member member, List<ItemResponseDto> items) {
        return MemberResponseDto.builder()
                .profileImage(member.getProfileImage())
                .nickname(member.getNickname())
                .drivingDegree(member.getDrivingDegree())
                .items(items)
                .build();
    }
}
