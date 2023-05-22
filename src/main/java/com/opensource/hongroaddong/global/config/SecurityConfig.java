package com.opensource.hongroaddong.global.config;

import com.opensource.hongroaddong.global.security.auth.*;
import com.opensource.hongroaddong.global.security.oauth.CookieOAuth2AuthorizationRequestRepository;
import com.opensource.hongroaddong.global.security.oauth.OAuth2FailureHandler;
import com.opensource.hongroaddong.global.security.oauth.OAuth2SuccessHandler;
import com.opensource.hongroaddong.global.security.oauth.ThirdPartyOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

import static org.springframework.http.HttpMethod.GET;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final CookieOAuth2AuthorizationRequestRepository oAuth2AuthorizationRequestRepository;
    private final ThirdPartyOAuth2UserService thirdPartyOAuth2UserService;
    private final OAuth2SuccessHandler successHandler;
    private final OAuth2FailureHandler failureHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(auth -> auth
                        .requestMatchers(GET, "/health").permitAll()
                        .requestMatchers("/docs", "swagger", "/swagger-ui/**", "/swagger-resources/**", "/v3/api-docs").permitAll()
                        .requestMatchers("/auth/renew").permitAll()
                        .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                        .anyRequest().authenticated())

                .apply(new JwtSecurityConfig(jwtTokenProvider))
                .and()

                .exceptionHandling()
                .accessDeniedHandler(jwtAccessDeniedHandler)
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()

                .csrf().disable()

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()

                .formLogin().disable()
                .httpBasic().disable()

                .oauth2Login()
                .authorizationEndpoint()
                .authorizationRequestRepository(oAuth2AuthorizationRequestRepository)
                .and()
                .userInfoEndpoint()
                .userService(thirdPartyOAuth2UserService)
                .and()
                .successHandler(successHandler)
                .failureHandler(failureHandler);

        http.addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}