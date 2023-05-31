package com.opensource.hongroaddong.domain.video.controller;

import com.opensource.hongroaddong.domain.common.ResponseDto;
import com.opensource.hongroaddong.domain.video.dto.request.VideoRequestDto;
import com.opensource.hongroaddong.domain.video.dto.response.VideoResponseDto;
import com.opensource.hongroaddong.domain.video.service.VideoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/video")
@Tag(name = "Video", description = "Video API")
public class VideoController {

    private final VideoService videoService;

    @PostMapping("/upload")
    public ResponseEntity<VideoResponseDto> uploadVideo(
            VideoRequestDto requestDto,
            @RequestPart(value = "file") MultipartFile multipartFile
    ) throws IOException {
        var response = videoService.uploadVideo(requestDto, multipartFile);
        return ResponseDto.created(response);
    }

    @GetMapping
    public ResponseEntity<List<VideoResponseDto>> findVideos(@RequestParam Long memberId) {
        var response = videoService.getVideos(memberId);
        return ResponseDto.ok(response);
    }
}
