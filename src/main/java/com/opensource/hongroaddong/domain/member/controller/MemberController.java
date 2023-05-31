package com.opensource.hongroaddong.domain.member.controller;

import com.opensource.hongroaddong.domain.common.ResponseDto;
import com.opensource.hongroaddong.domain.member.dto.response.MemberResponseDto;
import com.opensource.hongroaddong.domain.member.service.MemberService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
@Tag(name = "Member", description = "Member API")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponseDto> getMemberInfo(@Valid @PathVariable Long memberId) {
        var response = memberService.getMemberInfo(memberId);
        return ResponseDto.ok(response);
    }
}
