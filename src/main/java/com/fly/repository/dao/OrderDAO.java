package com.fly.repository.dao;

import com.fly.repository.entities.Order;

import java.sql.Date;
import java.util.List;

public interface OrderDAO extends GenericDAO<Order, Long> {
    List<Order> findOrderByDate(Date date);

    List<Order> findOrderByUser(Long userId);


}
