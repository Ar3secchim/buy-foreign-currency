package com.ada.order.Controller.dto.order;

import com.ada.order.model.TypeCurrency;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderRequest {
  private String cpfUser;
  private TypeCurrency typeCurrency;
  private BigDecimal valueForeignCurrency;
  private String withdrawalAgencyNumber;
}
