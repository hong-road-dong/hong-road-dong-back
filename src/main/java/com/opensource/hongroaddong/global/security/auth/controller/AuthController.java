package com.opensource.hongroaddong.global.security.auth.controller;

import com.opensource.hongroaddong.global.security.auth.JwtTokenProvider;
import com.opensource.hongroaddong.global.security.auth.dto.TokenResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("auth")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping(path = "renew/{refreshToken}")
    public TokenResponseDto renewToken(@PathVariable String refreshToken) {
        return jwtTokenProvider.renew(refreshToken);
    }
}
