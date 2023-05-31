package com.opensource.hongroaddong.domain.item.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemUploadRequestDto {
    @NotNull
    @Schema(description = "사용자 아이디", example = "1")
    private Long memberId;

    @NotNull
    @Schema(description = "비디오 아이디", example = "1")
    private Long videoId;

    @NotNull
    @Schema(description = "자동차 번호", example = "12다4567")
    private String carNumber;

    @Schema(description = "운전 수치 평가", example = "80")
    private int drivingDegree;

    @Schema(description = "코멘트", example = "운전 매너가 좋아요")
    private String comment;
}
