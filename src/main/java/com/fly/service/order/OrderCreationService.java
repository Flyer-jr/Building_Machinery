package com.fly.service.order;

import com.fly.repository.dao.ConflictRepository;
import com.fly.repository.dao.OrderRepository;
import com.fly.repository.entities.Equipment;
import com.fly.repository.entities.Order;
import com.fly.repository.entities.conflict.ConflictWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderCreationService {

  private final OrderRepository orderRepository;
  private final ConflictRepository conflictRepository;

  @Transactional(rollbackOn = Exception.class)
  public String saveOrder(Order requestOrder) {
    String message = "";
    Set<Equipment> equipmentSet = requestOrder.getEquipment();
    Set<ConflictWriter> conflictSet = new HashSet<>();
    List<Order> activeOrders = orderRepository.findOrdersByActiveIsTrue();

    for (Order order : activeOrders) {
      for (Equipment equipment : equipmentSet) {
        if (order.getEquipment().contains(equipment)) {
          order.getEquipment().remove(equipment);
          ConflictWriter conflict = new ConflictWriter();
          conflict.setSourceOrderId(order.getId());
          conflict.setEquipmentId(equipment.getId());
          conflict.setOperationDate(new Timestamp(System.currentTimeMillis()));
          conflictSet.add(conflict);
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
                        "The " + order.getId() + " Order's statement has been changed to FALSE \n");

      }
    }
    orderRepository.saveAll(activeOrders);
    Order order = orderRepository.saveAndFlush(requestOrder);

    for (ConflictWriter writer : conflictSet) {
      writer.setTargetOrderId(order.getId());
    }
    conflictRepository.saveAll(conflictSet);
    conflictRepository.flush();


    return message;
  }
}
