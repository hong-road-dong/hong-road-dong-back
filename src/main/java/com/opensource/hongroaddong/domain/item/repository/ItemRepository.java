package com.opensource.hongroaddong.domain.item.repository;

import com.opensource.hongroaddong.domain.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
