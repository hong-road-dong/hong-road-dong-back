package com.opensource.hongroaddong.domain.item.entity;

import com.opensource.hongroaddong.domain.car.entity.Car;
import com.opensource.hongroaddong.domain.common.BaseEntity;
import com.opensource.hongroaddong.domain.member.entity.Member;
import com.opensource.hongroaddong.domain.video.entity.Video;
import jakarta.persistence.*;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Item extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String comment;

    private int drivingDegree;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    @OneToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "video_id")
    private Video video;

}