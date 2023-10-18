package com.ada.order.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "order")
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String cpfUser;

  private LocalDateTime requestDate;

  @Column(nullable = false)
  private TypeCurrency typeCurrency;

  @Column(nullable = false)
  private BigDecimal valueForeignCurrency;

  private BigDecimal quotationValue;

  private BigDecimal valueTotalOperation;

  @Column(nullable = false)
  private String withdrawalAgencyNumber;
}
