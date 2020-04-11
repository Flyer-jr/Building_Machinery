//package com.fly.controller.convertor.order;
//
//import com.fly.controller.requests.customer.CustomerUpdateRequest;
//import com.fly.exceptions.EntityNotFoundException;
//import com.fly.repository.entities.Customer;
//import org.springframework.stereotype.Component;
//
//import static java.util.Optional.ofNullable;
//
//@Component
//public class OrderChangeRequestConverter
//    extends OrderRequestConverter<CustomerUpdateRequest, Customer> {
//
//  @Override
//  public Customer convert(CustomerUpdateRequest request) {
//    Customer customer =
//        ofNullable(entityManager.find(Customer.class, request.getCustomerId()))
//            .orElseThrow(
//                () -> new EntityNotFoundException(Customer.class, request.getCustomerId()));
//    return doConvert(customer, request);
//  }
//}
