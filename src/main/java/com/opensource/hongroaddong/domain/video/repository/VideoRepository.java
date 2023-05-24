package com.opensource.hongroaddong.domain.video.repository;

import com.opensource.hongroaddong.domain.video.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
