package com.ada.order.model.dto.order;

import com.ada.order.model.TypeCurrency;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class OrderRequest {
  private String cpfUser;
  private TypeCurrency typeCurrency;
  private BigDecimal valueForeignCurrency;
  private String withdrawalAgencyNumber;
}
