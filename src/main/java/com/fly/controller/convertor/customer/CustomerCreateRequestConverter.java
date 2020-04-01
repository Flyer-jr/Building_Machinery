package com.fly.controller.convertor.customer;

import com.fly.controller.requests.customer.CustomerCreateRequest;
import com.fly.repository.entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerCreateRequestConverter
    extends CustomerRequestConverter<CustomerCreateRequest, Customer> {

  @Override
  public Customer convert(CustomerCreateRequest request) {
    Customer customer = new Customer();
    return doConvert(customer, request);
  }
}
