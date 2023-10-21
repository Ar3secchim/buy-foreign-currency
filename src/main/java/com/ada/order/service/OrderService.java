package com.ada.order.service;

import com.ada.order.model.Order;
import com.ada.order.Controller.dto.order.OrderRequest;
import com.ada.order.Controller.dto.order.OrderResponse;
import com.ada.order.model.TypeCurrency;
import com.ada.order.repository.OrderRepository;
import com.ada.order.utils.OrderConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Currency;

@Service
public class OrderService {
  private final OrderRepository orderRepository;
  private final ExchangeService exchangeService;
  //private final UserRepository;

  @Autowired
  public OrderService(
    OrderRepository orderRepository,
    ExchangeService exchangeService) {
    this.orderRepository = orderRepository;

    this.exchangeService = exchangeService;
  }

  public OrderResponse create(OrderRequest orderRequest){
    TypeCurrency current = orderRequest.getTypeCurrency();
    BigDecimal rateExchange = exchangeService.getRateExchange(current);
    BigDecimal valueForeignCurrency = orderRequest.getValueForeignCurrency();

    Order order = OrderConvert.toEntity(orderRequest);
    order.setQuotationValue(rateExchange);
    order.setValueTotalOperation(calcValueTotalOperation(rateExchange, valueForeignCurrency));

    return OrderConvert.toResponse(orderRepository.save(order));
  }

  private static BigDecimal calcValueTotalOperation(BigDecimal rateExchange, BigDecimal value){
    return rateExchange.multiply(value);
  }
}
