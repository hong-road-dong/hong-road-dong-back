package com.opensource.hongroaddong.domain.member.service;

import com.opensource.hongroaddong.domain.member.entity.Member;
import com.opensource.hongroaddong.domain.member.repository.MemberRepository;
import com.opensource.hongroaddong.global.error.exception.common.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.opensource.hongroaddong.global.error.dto.ErrorCode.*;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Member findMember(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(MEMBER_NOT_FOUND));
    }

}
