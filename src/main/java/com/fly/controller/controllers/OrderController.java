package com.fly.controller.controllers;

import com.fly.controller.requests.order.OrderCreateRequest;
import com.fly.exceptions.EntityNotFoundException;
import com.fly.repository.dao.OrderRepository;
import com.fly.repository.dto.EntityListDTO;
import com.fly.repository.entities.Order;
import com.fly.service.order.OrderCreationService;
import com.fly.service.order.OrderValidationService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

  private final OrderRepository orderRepository;

  private final OrderCreationService creationService;
  private final OrderValidationService validationService;

  @Autowired
  @Qualifier(value = "mvcConversionService")
  private ConversionService conversionService;

  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<Order>> getAllOrders() {
    return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
  }

  @ApiOperation(value = "Get order from server by id")
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Order> getOrderById(@ApiParam("Order Id") @PathVariable String id) {
    Order order =
        orderRepository
            .findById(Long.valueOf(id))
            .orElseThrow(() -> new EntityNotFoundException(Order.class, id));
    return new ResponseEntity<>(order, HttpStatus.OK);
  }

  @ApiOperation(value = "Create order")
  @PostMapping
  @Transactional
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<String> createOrder(@ModelAttribute OrderCreateRequest request) {

    Order convertedOrder = conversionService.convert(request, Order.class);

    String message = creationService.saveOrder(convertedOrder);

    return new ResponseEntity(message, CREATED);
  }

  @ApiOperation(value = "Delete order from server by id")
  @DeleteMapping(value = "delete/{id}")
  @Transactional
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<String> deleteUserById(
      @ApiParam("User Path Id") @PathVariable("id") String id) {
    orderRepository.deleteById(Long.valueOf(id));
    return new ResponseEntity<>(id, HttpStatus.OK);
  }
}
