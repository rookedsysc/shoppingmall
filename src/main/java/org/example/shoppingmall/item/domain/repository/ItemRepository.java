package org.example.shoppingmall.item.domain.repository;

import org.example.shoppingmall.item.domain.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
  Optional<ItemEntity> findTop1ByItemName(String name);
}
