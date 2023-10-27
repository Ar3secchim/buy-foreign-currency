package com.ada.order.controller.dto.order;

import com.ada.order.model.TypeCurrency;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class OrderRequest {
  private String cpfUser;
  private LocalDateTime requestDate;
  private TypeCurrency typeCurrency;
  private BigDecimal valueForeignCurrency;
  private BigDecimal quotationValue;
  private BigDecimal valueTotalOperation;
  private String withdrawalAgencyNumber;
}
