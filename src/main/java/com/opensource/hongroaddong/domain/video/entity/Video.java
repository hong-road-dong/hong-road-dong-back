package com.opensource.hongroaddong.domain.video.entity;

import com.opensource.hongroaddong.domain.common.BaseEntity;
import com.opensource.hongroaddong.domain.member.entity.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;
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

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Builder
    public Video(String url, LocalDateTime timestamp, Member member) {
        this.url = url;
        this.timestamp = timestamp;
        this.member = member;
    }
}
