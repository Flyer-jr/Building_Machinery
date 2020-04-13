package com.fly.controller.convertor.customer;

import com.fly.controller.convertor.EntityConverter;
import com.fly.controller.requests.customer.CustomerCreateRequest;
import com.fly.repository.entities.Customer;

public abstract class CustomerRequestConverter<S, T> extends EntityConverter<S, T> {

  protected Customer doConvert(Customer customer, CustomerCreateRequest request) {

    customer.setCompanyName(request.getCompanyName());
    customer.setShortName(request.getShortName().toLowerCase());
    customer.setManagerName(request.getManagerName());
    customer.setPhoneNumber(request.getPhoneNumber());
    customer.setAddress(request.getAddress());

    return customer;
  }
}
