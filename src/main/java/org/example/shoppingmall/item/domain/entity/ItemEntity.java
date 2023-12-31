package org.example.shoppingmall.item.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.shoppingmall.item.constant.ItemStatus;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item")
public class ItemEntity {
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 50)
  private String itemName;

  @Column(nullable = false)
  private Integer price;

  @Column(nullable = false)
  private Integer stockNumber;

  @Column(nullable = false, columnDefinition = "LONGTEXT")
  private String itemDetail;

  @Enumerated(EnumType.STRING)
  @Column(length = 20, columnDefinition = "varchar(20)")
  private ItemStatus itemStatus;

  private LocalDateTime registeredAt;

  private LocalDateTime updatedAt;
}
