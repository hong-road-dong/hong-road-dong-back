package com.opensource.hongroaddong.domain.member.service;

import com.opensource.hongroaddong.domain.member.entity.Member;
import com.opensource.hongroaddong.domain.member.repository.MemberRepository;
import com.opensource.hongroaddong.global.error.exception.common.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.opensource.hongroaddong.global.error.dto.ErrorCode.*;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void updateDrivingDegree(Member member, int drivingDegree) {
        var degree = (drivingDegree - 50) / 100.0;
        member.updateDrivingDegree(degree);
        memberRepository.save(member);
    }

    public Member findMember(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(MEMBER_NOT_FOUND));
    }

}
