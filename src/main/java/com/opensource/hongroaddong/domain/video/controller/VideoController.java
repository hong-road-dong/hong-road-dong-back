package com.opensource.hongroaddong.domain.video.controller;

import com.opensource.hongroaddong.domain.common.ResponseDto;
import com.opensource.hongroaddong.domain.video.dto.request.VideoUploadRequestDto;
import com.opensource.hongroaddong.domain.video.dto.response.VideoResponseDto;
import com.opensource.hongroaddong.domain.video.service.VideoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/video")
@Tag(name = "🎥Video", description = "Video API")
public class VideoController {

    private final VideoService videoService;

    @PostMapping("/upload")
    @Operation(summary = "비디오 업로드하기")
    public ResponseEntity<VideoResponseDto> uploadVideo(
            @Valid @RequestBody VideoUploadRequestDto info,
            @RequestPart(value = "file") MultipartFile multipartFile
    ) throws IOException {
        var response = videoService.uploadVideo(info, multipartFile);
        return ResponseDto.created(response);
    }

    @GetMapping
    @Operation(summary = "내 비디오 가져오기")
    public ResponseEntity<List<VideoResponseDto>> findVideos(@RequestParam Long memberId) {
        var response = videoService.getVideos(memberId);
        return ResponseDto.ok(response);
    }
}
