package com.fly.service.order;

import com.fly.controller.requests.order.OrderCreateRequest;
import com.fly.controller.requests.order.ValidOrderCreateRequest;
import com.fly.repository.dao.EquipmentRepository;
import com.fly.repository.dao.OrderRepository;
import com.fly.repository.entities.Equipment;
import com.fly.repository.entities.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderCreationService {

  private final OrderRepository orderRepository;
  private final EquipmentRepository equipmentRepository;

  @Transactional
  public String saveOrder(Order requestOrder) {
    String message = "";
    Set<Equipment> equipmentSet = requestOrder.getEquipment();
    List<Order> activeOrders = orderRepository.findOrdersByActiveIsTrue();

    for (Order order : activeOrders) {
      for (Equipment equipment : equipmentSet) {
        if (order.getEquipment().contains(equipment)) {
          order.getEquipment().remove(equipment);
          message =
              message.concat(
                  "Equipment with id: "
                      + equipment.getId()
                      + " has been removed from order with id: "
                      + order.getId()
                      + "\n");
        }
      }
      if (order.getEquipment().isEmpty()) {
        order.setActive(Boolean.FALSE);
        message =
                message.concat(
                        "The "+ order.getId() + " Order's statement has been changed to FALSE \n");

      }
    }
    orderRepository.saveAll(activeOrders);
    orderRepository.saveAndFlush(requestOrder);


    return message;
  }
}
