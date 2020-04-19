package com.fly.controller.convertor.order;

import com.fly.controller.convertor.EntityConverter;
import com.fly.controller.requests.order.ValidOrderCreateRequest;
import com.fly.repository.entities.Order;
import lombok.AllArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
public abstract class OrderRequestConverter<S, T> extends EntityConverter<S, T> {

  protected Order doConvert(Order order, ValidOrderCreateRequest request) {


    order.setUser(request.getUser());
    order.setConstructionSite(request.getConstructionSite());
    order.setDateTaken(new Timestamp(System.currentTimeMillis()));
    order.setEquipment(request.getEquipment());
    order.setActive(Boolean.TRUE);
    return order;
  }
}
