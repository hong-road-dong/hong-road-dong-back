package com.opensource.hongroaddong.global.security.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import static lombok.AccessLevel.PRIVATE;

@Getter
@AllArgsConstructor(access = PRIVATE)
@Builder
public class AuthMemberDto {

    private final Long id;
    private final String email;
    private final String role;
}
