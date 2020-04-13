package com.fly.controller.convertor.order;

import com.fly.controller.requests.order.OrderCreateRequest;
import com.fly.controller.requests.order.ValidOrderCreateRequest;
import com.fly.repository.entities.Order;
import com.fly.service.order.OrderValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCreateRequestConverter extends OrderRequestConverter<OrderCreateRequest, Order> {

  private final OrderValidationService service;

  public Order convert(OrderCreateRequest request) {
    Order order = new Order();

    ValidOrderCreateRequest validRequest = service.createValid(request);

    return doConvert(order, validRequest);
  }
}
