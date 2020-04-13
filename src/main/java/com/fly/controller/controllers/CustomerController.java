package com.fly.controller.controllers;

import com.fly.controller.requests.customer.CustomerCreateRequest;
import com.fly.exceptions.EntityNotFoundException;
import com.fly.repository.dao.CustomerRepository;
import com.fly.repository.dto.EntityListDTO;
import com.fly.repository.entities.Customer;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

  private final CustomerRepository customerRepository;

  @Autowired
  @Qualifier(value = "mvcConversionService")
  private ConversionService conversionService;

  @GetMapping("/all")
  public ResponseEntity<List<Customer>> getCustomerList() {

    return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
  }

  @GetMapping("/allAsList")
  @ResponseStatus(HttpStatus.OK)
  public List<EntityListDTO> list() {
    return customerRepository.findAll().stream()
        .map(entity -> new EntityListDTO(entity.getId(), entity.getShortName()))
        .collect(Collectors.toList());
  }

  @ApiOperation(value = "Get customer from server by id")
  @GetMapping(value = "/{id}")
  public ResponseEntity<Customer> getCustomerById(
      @ApiParam("Customer Id") @PathVariable String id) {
    Customer customer =
        customerRepository
            .findById(Long.valueOf(id))
            .orElseThrow(() -> new EntityNotFoundException(Customer.class, id));
    return new ResponseEntity<>(customer, HttpStatus.OK);
  }

  @PostMapping
  @Transactional
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Customer> createCustomer(
      @ModelAttribute @Valid CustomerCreateRequest request) {
    Customer convertedCustomer = conversionService.convert(request, Customer.class);
    return new ResponseEntity<>(customerRepository.saveAndFlush(convertedCustomer), CREATED);
  }

  @DeleteMapping(value = "delete/{id}")
  @Transactional
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<String> deleteCustomerById(
      @ApiParam("Customer Id") @PathVariable("id") String id) {
    customerRepository.deleteById(Long.valueOf(id));
    return new ResponseEntity<>(id, HttpStatus.OK);
  }
}
