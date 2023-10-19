package com.ada.order.model.dto.order;

import com.ada.order.model.TypeCurrency;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
public class OrderResponse {
  private Integer id;
  private Integer idUser;
  private String cpfUser;
  private LocalDateTime requestDate;
  private TypeCurrency typeCurrency;
  private BigDecimal valueForeignCurrency;
  private BigDecimal quotationValue;
  private BigDecimal valueTotalOperation;
  private String withdrawalAgencyNumber;
}
