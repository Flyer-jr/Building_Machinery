package com.fly.service.order;

import com.fly.repository.dao.OrderConflictRepository;
import com.fly.repository.dao.OrderRepository;
import com.fly.repository.entities.Equipment;
import com.fly.repository.entities.Order;
import com.fly.repository.entities.OrderConflict;
import com.fly.service.mail.MailMessageCreator;
import com.fly.service.mail.MailSender;
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
  private final OrderConflictRepository conflictRepository;
  private final MailSender mailSender;
  private final MailMessageCreator messageCreator;

  @Transactional(rollbackOn = Exception.class)
  public String saveOrder(Order requestOrder) {
    String message = "";
    Set<Equipment> equipmentSet = requestOrder.getEquipment();
    Set<OrderConflict> conflictSet = new HashSet<>();
    List<Order> activeOrders = orderRepository.findOrdersByActiveIsTrue();


    for (Order order : activeOrders) {
      OrderConflict conflict = new OrderConflict();
      conflict.setSourceOrder(order);
      Set<Equipment> conflictEquipment = new HashSet<>();
      for (Equipment equipment : equipmentSet) {
        if (order.getEquipment().contains(equipment)) {
          order.getEquipment().remove(equipment);
          conflictEquipment.add(equipment);
          message =
                  message.concat(
                          "Equipment with id: "
                                  + equipment.getId()
                                  + " has been removed from order with id: "
                                  + order.getId()
                                  + "\n");
        }
        if (!equipmentSet.isEmpty()) {
          conflict.setEquipment(conflictEquipment);
          conflictSet.add(conflict);
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

    for (OrderConflict orderConflict : conflictSet) {
      orderConflict.setTargetOrder(order);
    }
    conflictRepository.saveAll(conflictSet);
    conflictRepository.flush();
    mailSender.sendMail(order.getUser().getEmail(), messageCreator.orderMessageCreate(order.getUser(),
            order));


    return message;
  }
}
