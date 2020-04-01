package com.fly.controller.controllers;

import com.fly.repository.dao.CustomerRepository;
import com.fly.repository.entities.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

  private final CustomerRepository customerRepository;

  @GetMapping("/all")
  public ResponseEntity<List<Customer>> getCustomerList() {

    return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
  }
}
