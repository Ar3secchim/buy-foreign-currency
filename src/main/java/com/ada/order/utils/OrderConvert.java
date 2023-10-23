package com.ada.order.utils;

import com.ada.order.model.Order;
import com.ada.order.controller.dto.order.OrderRequest;
import com.ada.order.controller.dto.order.OrderResponse;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

public class OrderConvert {

  public static Order toEntity(OrderRequest orderRequest){
    Order order = new Order();
    order.setCpfUser(orderRequest.getCpfUser());
    order.setTypeCurrency(orderRequest.getTypeCurrency());
    order.setRequestDate(LocalDateTime.now());
    order.setValueForeignCurrency(orderRequest.getValueForeignCurrency());
    order.setWithdrawalAgencyNumber(orderRequest.getWithdrawalAgencyNumber());

    return order;
  }

  public static OrderResponse toResponse(Order order){
    DecimalFormat df = new DecimalFormat("#,###.00");
    OrderResponse orderResponse = new OrderResponse();

    orderResponse.setId(order.getId());
    //TODO logic UserID
    orderResponse.setIdUser(1);
    orderResponse.setCpfUser(order.getCpfUser());
    orderResponse.setRequestDate(order.getRequestDate());
    orderResponse.setTypeCurrency(order.getTypeCurrency());
    orderResponse.setValueForeignCurrency(df.format(order.getValueForeignCurrency()));
    orderResponse.setQuotationValue(df.format(order.getQuotationValue()));
    orderResponse.setValueTotalOperation(df.format(order.getValueTotalOperation()));
    orderResponse.setWithdrawalAgencyNumber(order.getWithdrawalAgencyNumber());

    return orderResponse;
  }
}
