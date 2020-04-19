package com.fly.repository.dao;

import com.fly.repository.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, CrudRepository<Order, Long> {

     List<Order> findOrdersByActiveIsTrue();




//  List<Order> findOrderByUser(Long userId);
}
