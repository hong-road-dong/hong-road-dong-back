package com.opensource.hongroaddong.domain.timestamp.entity;

import com.opensource.hongroaddong.domain.video.entity.Video;
import com.opensource.hongroaddong.global.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Timestamp extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "timestamp_id")
    private Long id;

    @NotNull
    private LocalDateTime time;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "video_id")
    private Video video;

}
