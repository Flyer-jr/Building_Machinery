package com.fly.service.order;

import com.fly.controller.requests.order.OrderCreateRequest;
import com.fly.controller.requests.order.ValidOrderCreateRequest;
import com.fly.repository.dao.ConflictRepository;
import com.fly.repository.dao.EquipmentRepository;
import com.fly.repository.dao.OrderRepository;
import com.fly.repository.entities.ConflictContainer;
import com.fly.repository.entities.Equipment;
import com.fly.repository.entities.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.sql.rowset.CachedRowSet;
import javax.transaction.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderCreationService {

  private final OrderRepository orderRepository;
  private final ConflictRepository conflictRepository;

  @Transactional
  public String saveOrder(Order requestOrder) {
    Calendar calendar = Calendar.getInstance();
    String message = "";
    Set<Equipment> equipmentSet = requestOrder.getEquipment();
    Set<ConflictContainer> conflictSet = Collections.emptySet();
    List<Order> activeOrders = orderRepository.findOrdersByActiveIsTrue();

    for (Order order : activeOrders) {
      for (Equipment equipment : equipmentSet) {
        if (order.getEquipment().contains(equipment)) {
          order.getEquipment().remove(equipment);
          ConflictContainer conflict = new ConflictContainer();
          conflict.setSourceOrderId(order.getId());
          conflict.setEquipmentId(equipment.getId());
          conflict.setOperationDate(calendar.getTime());
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
                        "The "+ order.getId() + " Order's statement has been changed to FALSE \n");

      }
    }
    orderRepository.saveAll(activeOrders);
    Order order = orderRepository.saveAndFlush(requestOrder);

    for(ConflictContainer container : conflictSet){
      container.setTargetOrderId(order.getId());}
    conflictRepository.saveAll(conflictSet);
    conflictRepository.flush();


    return message;
  }
}
