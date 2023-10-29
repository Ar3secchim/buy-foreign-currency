package com.ada.order.Controller;

import com.ada.order.controller.dto.order.OrderRequest;
import com.ada.order.controller.dto.order.OrderResponse;
import com.ada.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest){
      OrderResponse order =  orderService.create(orderRequest);
      return ResponseEntity
              .created(URI.create("/"+order.getId()))
              .body(order);
    }
}
