package com.fly.controller.convertor.order;

import com.fly.controller.requests.customer.CustomerCreateRequest;
import com.fly.controller.requests.order.OrderCreateRequest;
import com.fly.controller.requests.order.ValidOrderCreateRequest;
import com.fly.repository.dao.ConstructionSiteRepository;
import com.fly.repository.dao.EquipmentRepository;
import com.fly.repository.dao.UserRepository;
import com.fly.repository.entities.Customer;
import com.fly.repository.entities.Equipment;
import com.fly.repository.entities.Order;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderCreateRequestConverter extends OrderRequestConverter<OrderCreateRequest, Order> {
  @Autowired
  private final UserRepository userRepository;
  @Autowired
  private final ConstructionSiteRepository siteRepository;
  @Autowired
  private final EquipmentRepository equipmentRepository;

  public Order convert(OrderCreateRequest requestOrder) {
    Order order = new Order();
    ValidOrderCreateRequest validRequest = new ValidOrderCreateRequest();
    validRequest.setUser(userRepository.findUserBySecondName(requestOrder.getUserName()));
    validRequest.setConstructionSite(siteRepository.findSiteByShortName(requestOrder.getConstructionSiteShortName()));
    validRequest.setEquipment(
            new HashSet<>(equipmentRepository.findAllById(requestOrder.getEquipment())));

    return doConvert(order, validRequest);
  }
}
