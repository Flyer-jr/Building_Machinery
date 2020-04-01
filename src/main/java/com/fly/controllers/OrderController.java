package com.fly.controllers;

import com.fly.repository.hibernate.HibernateOrder;
import com.fly.repository.hibernateDAO.HibernateOrderDAO;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {

    private final HibernateOrderDAO order;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<List<HibernateOrder>> getOrderList(){
        return new ResponseEntity<>(order.findAll(), HttpStatus.OK);

    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<HibernateOrder> getById(@ApiParam("User Path Id") @PathVariable String id){
        return new ResponseEntity<>(order.findById(Long.valueOf(id)), HttpStatus.OK);
    }

}
