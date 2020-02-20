package com.fly.repository.impl;

import com.fly.repository.dao.CustomerDAO;
import com.fly.repository.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@Repository
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
    public List<Customer> findCustomerByManager(String query) {

        final String findByManagerQuery = "SELECT * FROM m_customers WHERE lower(manager) LIKE lower(query)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("query", "%" + query + "%");

        return namedParameterJdbcTemplate.query(findByManagerQuery,parameterSource,this::getCustomerRowMapper);
    }

    @Override
    public Customer findCustomerByCompanyName(String companyName) {

        final String findByCompanyNameQuery = "SELECT * FROM m_customers WHERE" +
                "lower(company_name) LIKE lower(companyName)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("companeName", "%" + companyName + "%" );
        return namedParameterJdbcTemplate.queryForObject(findByCompanyNameQuery,parameterSource, this::getCustomerRowMapper);
    }

    @Override
    public List<Customer> findAll() {
        final String findAllQuery = "select * from m_customers";
        return namedParameterJdbcTemplate.query(findAllQuery, this::getCustomerRowMapper);
    }

    @Override
    public Customer findById(Long id) {

        final String findByIdQuery = "SELECT * FROM m_customers where id = :customerId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("customerId", id);

        return namedParameterJdbcTemplate.queryForObject(findByIdQuery,parameterSource, this::getCustomerRowMapper);
    }

    @Override
    public void delete(Long id) {

        final String deleteQuery = "DELETE * FROM m_cutomers WHERE id = :customerId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("customerId", id);
        namedParameterJdbcTemplate.update(deleteQuery,parameterSource);

        }

    @Override
    public Customer save(Customer entity) {

        final String updateQuery = "INSERT INTO m_customers set (company_name, adress, manager, phone_number)" +
                "VALUES (:companyName, :adress, :manager, :phoneNumber)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("companyName", entity.getCompanyName());
        parameterSource.addValue("adress", entity.getAdress());
        parameterSource.addValue("manager", entity.getManagerName());
        parameterSource.addValue("phoneNumber", entity.getPhoneNumber());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(updateQuery,parameterSource,keyHolder);
        Long newGeneratedCustomerId = Objects.requireNonNull(keyHolder.getKey().longValue());

        return findById(newGeneratedCustomerId);
    }

    @Override
    public Customer update(Customer entity) {

        final String updateQuery = "UPDATE m_customers SET company_name = :companyName, adress = :adress," +
                "manager = :manager, phone_number = :phoneNumber WHERE id = :customerId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("companyName", entity.getCompanyName());
        parameterSource.addValue("adress", entity.getAdress());
        parameterSource.addValue("manager", entity.getManagerName());
        parameterSource.addValue("phoneNumber", entity.getPhoneNumber());
        parameterSource.addValue("customerId", entity.getId());
        namedParameterJdbcTemplate.update(updateQuery,parameterSource);

        return findById(entity.getId());
    }
}
