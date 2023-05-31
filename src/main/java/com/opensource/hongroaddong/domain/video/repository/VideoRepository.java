package com.opensource.hongroaddong.domain.video.repository;

import com.opensource.hongroaddong.domain.member.entity.Member;
import com.opensource.hongroaddong.domain.video.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {
    @Query("select v from Video v where v.member = :member order by v.timestamp desc")
    List<Video> findAllByMember(@Param("member") Member member);
}
