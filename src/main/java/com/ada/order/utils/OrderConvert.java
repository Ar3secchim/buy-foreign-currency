package com.ada.order.utils;

import com.ada.order.model.Order;
import com.ada.order.model.dto.order.OrderRequest;
import com.ada.order.model.dto.order.OrderResponse;

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
    //TODO logic UserID

    OrderResponse orderResponse = new OrderResponse();
    orderResponse.setId(order.getId());
    orderResponse.setIdUser(1);
    orderResponse.setCpfUser(order.getCpfUser());
    orderResponse.setRequestDate(order.getRequestDate());
    orderResponse.setTypeCurrency(order.getTypeCurrency());
    orderResponse.setValueForeignCurrency(order.getValueForeignCurrency());
    orderResponse.setQuotationValue(order.getQuotationValue());
    orderResponse.setValueTotalOperation(order.getValueTotalOperation());
    orderResponse.setWithdrawalAgencyNumber(order.getWithdrawalAgencyNumber());

    return orderResponse;
  }
}
