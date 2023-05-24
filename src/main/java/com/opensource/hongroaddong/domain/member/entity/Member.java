package com.opensource.hongroaddong.domain.member.entity;

import com.opensource.hongroaddong.domain.car.entity.Car;
import com.opensource.hongroaddong.domain.item.entity.Item;
import com.opensource.hongroaddong.domain.common.BaseEntity;
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
    @Length(max = 24)
    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String provider;

    private String profileImage;

    @Column(unique = true)
    private String accountEmail;

    @Length(max = 24)
    private String nickname;

    private Double drivingDegree;

    @OneToMany(mappedBy = "member", fetch = LAZY, cascade = ALL, orphanRemoval = true)
    private Set<Car> cars = new HashSet<>();

    @OneToMany(mappedBy = "member", fetch = LAZY, cascade = ALL, orphanRemoval = true)
    private Set<Item> items = new HashSet<>();

}