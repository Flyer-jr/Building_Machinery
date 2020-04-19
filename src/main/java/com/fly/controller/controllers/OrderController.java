package com.fly.controller.controllers;

import com.fly.controller.requests.order.OrderCreateRequest;
import com.fly.exceptions.EntityNotFoundException;
import com.fly.repository.dao.OrderRepository;
import com.fly.repository.entities.Order;
import com.fly.service.order.OrderCreationService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

  private final OrderRepository orderRepository;
  private final OrderCreationService creationService;


  @Autowired
  @Qualifier(value = "mvcConversionService")
  private ConversionService conversionService;

  @ApiOperation(value = "Get all orders from server")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  @Secured("ROLE_USER")
  public ResponseEntity<List<Order>> getAllOrders() {
    return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
  }

  @ApiOperation(value = "Get order from server by id")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Order> getOrderById(@ApiParam("Order Id") @PathVariable String id) {
    Order order =
        orderRepository
            .findById(Long.valueOf(id))
            .orElseThrow(() -> new EntityNotFoundException(Order.class, id));
    return new ResponseEntity<>(order, HttpStatus.OK);
  }

  @ApiOperation(value = "Create new order")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @PostMapping
  @Transactional
  @ResponseBody
  @Secured("ROLE_USER")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<String> createOrder(@ModelAttribute OrderCreateRequest request) {

    Order convertedOrder = conversionService.convert(request, Order.class);

    String message = creationService.saveOrder(convertedOrder);

    return new ResponseEntity(message, CREATED);
  }

  @ApiOperation(value = "Delete order from server by id")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @DeleteMapping(value = "delete/{id}")
  @Transactional
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<String> deleteOrderById(
      @ApiParam("User Path Id") @PathVariable("id") String id) {
    orderRepository.deleteById(Long.valueOf(id));
    return new ResponseEntity<>(id, HttpStatus.OK);
  }
}
