package com.fly.repository.dao;

import com.fly.repository.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository
    extends JpaRepository<Customer, Long>, CrudRepository<Customer, Long> {
  List<Customer> findCustomerByManagerName(String manager);

  Customer findCustomerByCompanyName(String companyName);
}
