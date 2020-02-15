package com.fly.repository.dao;

import com.fly.repository.entities.Customer;

public interface CustomerDAO extends GenericDAO<Customer, Long> {
    Customer findByManager(String manager);

    Customer findByCompanyName(String companyName);


}
