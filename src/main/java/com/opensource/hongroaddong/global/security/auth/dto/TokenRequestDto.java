package com.opensource.hongroaddong.global.security.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TokenRequestDto {

    private String refreshToken;
}