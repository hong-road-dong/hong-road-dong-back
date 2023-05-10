package com.opensource.hongroaddong.domain.member.entity;

import com.opensource.hongroaddong.domain.car.entity.Car;
import com.opensource.hongroaddong.domain.item.entity.Item;
import com.opensource.hongroaddong.domain.video.entity.Video;
import com.opensource.hongroaddong.global.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @NotNull
    private String provider;

    @NotNull
    @Length(max = 24)
    private String name;

    @NotNull
    private String profileImage;

    @NotNull
    @Column(unique = true)
    private String accountEmail;

    @NotNull
    @Length(max = 24)
    private String nickname;

    @OneToMany(mappedBy = "member", fetch = LAZY, cascade = ALL, orphanRemoval = true)
    Set<Video> videos = new HashSet<>();

    @OneToMany(mappedBy = "member", fetch = LAZY, cascade = ALL, orphanRemoval = true)
    Set<Item> items = new HashSet<>();

    @ManyToMany(fetch = LAZY)
    @JoinTable(
            name = "member_car",
            joinColumns = {@JoinColumn(name = "memberId", referencedColumnName = "member_id")},
            inverseJoinColumns = {@JoinColumn(name = "carId", referencedColumnName = "car_id")})
    private Set<Car> cars = new HashSet<>();

}