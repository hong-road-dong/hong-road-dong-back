package com.opensource.hongroaddong.domain.video.entity;

import com.opensource.hongroaddong.domain.member.entity.Member;
import com.opensource.hongroaddong.domain.timestamp.entity.Timestamp;
import com.opensource.hongroaddong.global.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Video extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "video_id")
    private Long id;

    @NotNull
    private String url;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "video", fetch = LAZY, cascade = ALL, orphanRemoval = true)
    private Set<Timestamp> timestamps = new HashSet<>();

}