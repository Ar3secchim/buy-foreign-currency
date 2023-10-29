package com.ada.order.service;

import com.ada.order.model.Order;
import com.ada.order.controller.dto.order.OrderRequest;
import com.ada.order.controller.dto.order.OrderResponse;
import com.ada.order.model.TypeCurrency;
import com.ada.order.model.User;
import com.ada.order.repository.IOrderRepository;
import com.ada.order.repository.IUserRepository;
import com.ada.order.utils.OrderConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {
  private final IOrderRepository orderRepository;
  private final ExchangeService exchangeService;
  private  final IUserRepository userRepository;

  @Autowired
  public OrderService (IOrderRepository orderRepository, ExchangeService exchangeService, IUserRepository userRepository) {
    this.orderRepository = orderRepository;
    this.exchangeService = exchangeService;
    this.userRepository = userRepository;
  }

  public OrderResponse create(OrderRequest orderRequest){
    User user = (User) userRepository.findByCpf(orderRequest.getCpfUser());
    Integer idUser = user.getId();

    TypeCurrency current = orderRequest.getTypeCurrency();

    if (current != TypeCurrency.USD || current != TypeCurrency.EUR ){
      throw new RuntimeException("TypeCurrency invalid. Use dollar (USD) or euros (EUR)");
    }


    BigDecimal rateExchange = exchangeService.getRateExchange(current);
    BigDecimal valueForeignCurrency = orderRequest.getValueForeignCurrency();

    Order order = OrderConvert.toEntity(orderRequest);
    order.setQuotationValue(rateExchange);
    order.setValueTotalOperation(calcValueTotalOperation(rateExchange, valueForeignCurrency));
//,idUser.getId()
    return OrderConvert.toResponse(orderRepository.save(order), idUser);
  }

  private static BigDecimal calcValueTotalOperation(BigDecimal rateExchange, BigDecimal value){
    return rateExchange.multiply(value);
  }
}
