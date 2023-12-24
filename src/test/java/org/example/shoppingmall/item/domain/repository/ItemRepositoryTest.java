package org.example.shoppingmall.item.domain.repository;

import jakarta.transaction.Transactional;
import org.example.shoppingmall.item.constant.ItemStatus;
import org.example.shoppingmall.item.domain.entity.ItemEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

// 통합테스트를 위해 스프링 부트에서 제공하는 어노테이션
// 실제 어플리케이션을 구동할 때처럼 모든 Bean을 IoC에 등록한다.
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.yaml")
@Transactional
class ItemRepositoryTest {

  @Autowired
  ItemRepository itemRepository;

  @Test
  @DisplayName("상품 저장")
  public void save() {
    // given
    ItemEntity item =  customItem();

    // when
    ItemEntity result = itemRepository.save(item);

    // then
    assertNotNull(result.getId());
    assertEquals(item.getItemName(), result.getItemName());
    assertEquals(item.getPrice(), result.getPrice());
    assertEquals(item.getItemDetail(), result.getItemDetail());
    assertEquals(item.getItemStatus(), result.getItemStatus());
    assertEquals(item.getStockNumber(), result.getStockNumber());
  }

  @Test
  @DisplayName("상품 조회")
  public void findByItemName() {
    // given
    ItemEntity item =  customItem();

    // when
    ItemEntity findResult = itemRepository.findTop1ByItemName(item.getItemName()).orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다."));

    System.out.println("Debug Point");

    // then
    assertNotNull(findResult.getId());
    assertEquals(item.getItemName(), findResult.getItemName());
    assertEquals(item.getPrice(), findResult.getPrice());
    assertEquals(item.getItemDetail(), findResult.getItemDetail());
    assertEquals(item.getItemStatus(), findResult.getItemStatus());
    assertEquals(item.getStockNumber(), findResult.getStockNumber());
  }

  public ItemEntity customItem() {
        return  ItemEntity.builder()
        .itemName("테스트 상품")
        .price(10000)
        .itemDetail("테스트 상품 상세 설명")
        .itemStatus(ItemStatus.SELL)
        .stockNumber(100)
        .registeredAt(LocalDateTime.now())
        .updatedAt(LocalDateTime.now())
        .build();
  }
}