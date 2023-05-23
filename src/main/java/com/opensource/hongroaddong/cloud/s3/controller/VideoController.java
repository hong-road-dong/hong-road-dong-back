package com.opensource.hongroaddong.cloud.s3.controller;

import com.opensource.hongroaddong.cloud.s3.dto.VideoResponseDto;
import com.opensource.hongroaddong.cloud.s3.service.S3Service;
import com.opensource.hongroaddong.domain.common.ResponseDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/video")
@Tag(name = "Video", description = "Video API")
public class VideoController {

    private final S3Service s3Service;

    @PostMapping("/upload")
    public ResponseEntity<VideoResponseDto> uploadVideo(
            @RequestPart(value = "file") MultipartFile multipartFile) throws IOException {
        return ResponseDto.created(s3Service.uploadFile(multipartFile));
    }

}
