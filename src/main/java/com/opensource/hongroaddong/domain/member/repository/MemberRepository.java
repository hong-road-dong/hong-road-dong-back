package com.opensource.hongroaddong.domain.member.repository;

import com.opensource.hongroaddong.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
