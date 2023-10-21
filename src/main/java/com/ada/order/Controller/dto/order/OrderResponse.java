package com.ada.order.Controller.dto.order;

import com.ada.order.model.TypeCurrency;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
public class OrderResponse {
  private Integer id;
  private Integer idUser;
  private String cpfUser;
  private LocalDateTime requestDate;
  private TypeCurrency typeCurrency;
  private String valueForeignCurrency;
  private String quotationValue;
  private String valueTotalOperation;
  private String withdrawalAgencyNumber;
}
