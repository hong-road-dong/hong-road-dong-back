package com.opensource.hongroaddong.domain.car.entity;

import com.opensource.hongroaddong.domain.item.entity.Item;
import com.opensource.hongroaddong.domain.member.entity.Member;
import com.opensource.hongroaddong.global.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Car extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "car_id")
    private Long id;

    @NotNull
    private int number;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "car", fetch = LAZY, cascade = ALL, orphanRemoval = true)
    Set<Item> items = new HashSet<>();

}