package com.ada.order.service;

import com.ada.order.model.Order;
import com.ada.order.model.dto.order.OrderRequest;
import com.ada.order.model.dto.order.OrderResponse;
import com.ada.order.repository.OrderRepository;
import com.ada.order.utils.OrderConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
  private final OrderRepository orderRepository;

  @Autowired
  public OrderService(
    OrderRepository orderRepository
  ) {
    this.orderRepository = orderRepository;
  }

  public OrderResponse createOrder(OrderRequest orderRequest){
    // Verifica se o cliente com o CPF existe

    // Obtém a taxa de câmbio da moeda

    // Calcula o valor total da operação

    // Crie a ordem de compra
    Order order = OrderConvert.toEntity(orderRequest);

    // Salve a ordem de compra no banco de dados
    return OrderConvert.toResponse(orderRepository.save(order));
  }
}
