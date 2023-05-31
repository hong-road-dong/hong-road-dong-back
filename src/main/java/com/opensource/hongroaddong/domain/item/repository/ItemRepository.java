package com.opensource.hongroaddong.domain.item.repository;

import com.opensource.hongroaddong.domain.item.entity.Item;
import com.opensource.hongroaddong.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("select i from Item i where i.car.member = :member order by i.createdAt DESC")
    List<Item> findAllByCarMember(@Param("member") Member member);
}
