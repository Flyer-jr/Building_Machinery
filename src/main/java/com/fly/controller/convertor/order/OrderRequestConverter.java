package com.fly.controller.convertor.order;

import com.fly.controller.convertor.EntityConverter;
import com.fly.controller.requests.order.ValidOrderCreateRequest;
import com.fly.repository.entities.Order;
import lombok.AllArgsConstructor;
import java.util.*;

@AllArgsConstructor
public abstract class OrderRequestConverter<S, T> extends EntityConverter<S, T> {

  protected Order doConvert(Order order, ValidOrderCreateRequest request) {
    Calendar calendar = Calendar.getInstance();

    order.setUser(request.getUser());
    order.setConstructionSite(request.getConstructionSite());
    order.setDateTaken(calendar.getTime());
    order.setEquipment(request.getEquipment());
    order.setActive(Boolean.TRUE);
    return order;
  }
}
