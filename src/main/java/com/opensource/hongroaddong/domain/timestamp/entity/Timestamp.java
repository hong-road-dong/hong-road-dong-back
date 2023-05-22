package com.opensource.hongroaddong.domain.timestamp.entity;

import com.opensource.hongroaddong.domain.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Timestamp extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "timestamp_id")
    private Long id;

    @NotNull
    private LocalDateTime time;

}
