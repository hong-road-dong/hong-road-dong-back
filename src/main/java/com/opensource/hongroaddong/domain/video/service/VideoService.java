package com.opensource.hongroaddong.domain.video.service;

import com.opensource.hongroaddong.cloud.s3.service.S3Service;
import com.opensource.hongroaddong.domain.member.service.MemberService;
import com.opensource.hongroaddong.domain.video.dto.request.VideoRequestDto;
import com.opensource.hongroaddong.domain.video.dto.response.VideoResponseDto;
import com.opensource.hongroaddong.domain.video.entity.Video;
import com.opensource.hongroaddong.domain.video.repository.VideoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class VideoService {
    private final S3Service s3Service;
    private final MemberService memberService;
    private final VideoRepository videoRepository;

    @Transactional
    public VideoResponseDto uploadVideo(VideoRequestDto requestDto, MultipartFile uploadFile) throws IOException {
        var member = memberService.findMember(requestDto.getMemberId());
        var timestamp = requestDto.getTimestamp();
        var url = s3Service.uploadFile(uploadFile);
        var video = Video.builder()
                .member(member)
                .timestamp(timestamp)
                .url(url)
                .build();
        var saved = videoRepository.save(video);
        return VideoResponseDto.from(saved);
    }

}
