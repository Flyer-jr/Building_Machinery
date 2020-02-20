package com.fly.repository.dao;

import com.fly.repository.entities.Customer;

import java.util.List;

public interface CustomerDAO extends GenericDAO<Customer, Long> {
    List<Customer> findCustomerByManager(String manager);

    Customer findCustomerByCompanyName(String companyName);


}
