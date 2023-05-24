package com.opensource.hongroaddong.domain.video.entity;

import com.opensource.hongroaddong.domain.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@NoArgsConstructor
@Entity
public class Video extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "video_id")
    private Long id;

    @NotNull
    private String url;

    @NotNull
    private LocalDateTime timestamp;

    @Builder
    public Video(String url, LocalDateTime timestamp) {
        this.url = url;
        this.timestamp = timestamp;
    }
}
