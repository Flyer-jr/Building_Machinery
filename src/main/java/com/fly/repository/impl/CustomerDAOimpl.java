package com.fly.repository.impl;

import com.fly.repository.CustomerDAO;
import com.fly.repository.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerDAOimpl implements CustomerDAO {

    public static final String CUSTOMER_ID = "id";
    public static final String CUSTOMER_COMPANY_NAME = "company_name";
    public static final String CUSTOMER_ADRESS = "adress";
    public static final String CUSTOMER_MANAGER = "manager";
    public static final String CUSTOMER_PHONE_NUMBER = "phone_number";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public CustomerDAOimpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    private Customer getCustomerRowMapper (ResultSet resultSet, int i) throws SQLException {

        Customer customer = new Customer();

       customer.setId(resultSet.getLong(CUSTOMER_ID));
       customer.setCompanyName(resultSet.getString(CUSTOMER_COMPANY_NAME));
       customer.setAdress(resultSet.getString(CUSTOMER_ADRESS));
       customer.setManagerName(resultSet.getString(CUSTOMER_MANAGER));
       customer.setPhoneNumber(resultSet.getString(CUSTOMER_PHONE_NUMBER));
       return  customer;

    }

    @Override
    public Customer findByManager(String manager) {
        return null;
    }

    @Override
    public Customer findByCompanyName(String companyName) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Customer save(Customer entity) {
        return null;
    }

    @Override
    public Customer update(Customer entity) {
        return null;
    }
}
