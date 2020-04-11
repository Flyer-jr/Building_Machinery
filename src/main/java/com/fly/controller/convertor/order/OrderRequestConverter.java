package com.fly.controller.convertor.order;

import com.fly.controller.convertor.EntityConverter;

import com.fly.controller.requests.order.OrderCreateRequest;
import com.fly.controller.requests.order.ValidOrderCreateRequest;
import com.fly.repository.dao.ConstructionSiteRepository;
import com.fly.repository.dao.EquipmentRepository;
import com.fly.repository.dao.UserRepository;

import com.fly.repository.entities.Equipment;
import com.fly.repository.entities.Order;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
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
