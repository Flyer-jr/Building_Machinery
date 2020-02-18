package com.fly.repository.dao;

import com.fly.repository.entities.Customer;

import java.util.List;

public interface CustomerDAO extends GenericDAO<Customer, Long> {
    List<Customer> findByManager(String manager);

    Customer findByCompanyName(String companyName);


}
