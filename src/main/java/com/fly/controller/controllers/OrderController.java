package com.fly.controller.controllers;

import com.fly.exceptions.EntityNotFoundException;
import com.fly.repository.dao.OrderRepository;
import com.fly.repository.entities.Order;
import com.fly.repository.entities.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {

  private final OrderRepository orderRepository;

  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  private ResponseEntity<List<Order>> getOrderList() {
    return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
  }

    @ApiOperation(value = "Get user from server by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful getting order"),
            @ApiResponse(code = 400, message = "Invalid Order ID supplied"),
            @ApiResponse(code = 401, message = "Lol kek"),
            @ApiResponse(code = 404, message = "Order was not found"),
            @ApiResponse(code = 500, message = "Server error, something wrong")
    })

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  private ResponseEntity<Order> getOrderById(@ApiParam("Order Id") @PathVariable String id) {
        Order order = orderRepository.findById(Long.valueOf(id)).orElseThrow(() -> new EntityNotFoundException(Order.class, id));
        return new ResponseEntity<>(order, HttpStatus.OK);}
}
