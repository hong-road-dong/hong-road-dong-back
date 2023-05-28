package com.opensource.hongroaddong.domain.member.service;

import com.opensource.hongroaddong.domain.member.entity.Member;
import com.opensource.hongroaddong.domain.member.repository.MemberRepository;
import com.opensource.hongroaddong.global.error.exception.common.NotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("[Service] MemberService Test")
public class MemberServiceTest {

    @InjectMocks
    MemberService memberService;

    @Mock
    MemberRepository memberRepository;

    @Nested
    @DisplayName("사용자 조회 테스트")
    class FindMemberTest {
        @Nested
        @DisplayName("성공")
        class FindMemberTestSuccess {
            @Test
            @DisplayName("사용자 조회 테스트 성공")
            void findMember() {
                Member member = new Member();
                when(memberRepository.findById(anyLong())).thenReturn(Optional.of(member));
                var result = memberService.findMember(1L);

                assertThat(result).isEqualTo(member);
            }
        }

        @Nested
        @DisplayName("실패")
        class FindMemberTestFail {
            @Test
            @DisplayName("사용자 조회 테스트 실패")
            void findMember() {
                when(memberRepository.findById(anyLong())).thenReturn(Optional.empty());
                assertThrows(NotFoundException.class, () -> memberService.findMember(1L));
            }
        }
    }
}
