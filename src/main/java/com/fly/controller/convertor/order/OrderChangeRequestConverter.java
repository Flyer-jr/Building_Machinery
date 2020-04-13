package com.fly.controller.convertor.order;

import com.fly.controller.requests.order.OrderUpdateRequest;
import com.fly.exceptions.EntityNotFoundException;
import com.fly.repository.entities.Order;
import com.fly.service.order.OrderValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

@Component
@RequiredArgsConstructor
public class OrderChangeRequestConverter extends OrderRequestConverter<OrderUpdateRequest, Order> {

  private final OrderValidationService service;

  @Override
  public Order convert(OrderUpdateRequest request) {
    Order Order =
        ofNullable(entityManager.find(Order.class, request.getOrderId()))
            .orElseThrow(() -> new EntityNotFoundException(Order.class, request.getOrderId()));
    return doConvert(Order, service.createValid(service.makeCreateRequest(request)));
  }
}
