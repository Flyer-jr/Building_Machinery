package com.fly.controller.convertor.customer;

import com.fly.controller.requests.customer.CustomerUpdateRequest;
import com.fly.exceptions.EntityNotFoundException;
import com.fly.repository.entities.Customer;
import org.springframework.stereotype.Component;
import static java.util.Optional.ofNullable;

@Component
public class CustomerChangeRequestConverter
    extends CustomerRequestConverter<CustomerUpdateRequest, Customer> {

  @Override
  public Customer convert(CustomerUpdateRequest request) {
    Customer customer =
        ofNullable(entityManager.find(Customer.class, request.getCustomerId()))
            .orElseThrow(
                () -> new EntityNotFoundException(Customer.class, request.getCustomerId()));
    return doConvert(customer, request);
  }
}
