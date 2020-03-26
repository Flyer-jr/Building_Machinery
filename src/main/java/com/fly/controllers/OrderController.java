package com.fly.controllers;

import com.fly.repository.hibernate.HibernateOrder;
import com.fly.repository.hibernateDAO.HibernateOrderDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {

    private final HibernateOrderDAO order;

    @RequestMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<List<HibernateOrder>> getOrderList(){
        return new ResponseEntity<>(order.findAll(), HttpStatus.OK);
    }

}
