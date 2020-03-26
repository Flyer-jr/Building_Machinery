//package com.fly.controllers;
//
//import com.fly.repository.hibernate.HibernateCustomer;
//import com.fly.repository.hibernateDAO.HibernateCustomerDAO;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/customer")
//public class CustomerController {
//
//    private final HibernateCustomerDAO customer;
//
//    @RequestMapping("/all")
//    public ResponseEntity<List<HibernateCustomer>> getCustomerList(){
//
//        return new ResponseEntity<>(customer.findAll(), HttpStatus.OK);
//    }
//}
