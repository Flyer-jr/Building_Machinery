package com.fly.repository.impl;

import com.fly.repository.OrderDAO;
import com.fly.repository.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderDAOimpl implements OrderDAO {

    private static final String ORDER_ID = "id";
    private static final String ORDER_USER_ID = "user_id";
    private static final String ORDER_CONSTRUCTION_SITE_ID = "construction_site_id";
    private static final String ORDER_DATE_TAKEN = "date_taken";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public OrderDAOimpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private Order getOrderRowMapper (ResultSet resultSet, int i) throws SQLException {

        Order order = new Order();

        order.setId(resultSet.getLong(ORDER_ID));
        order.setUserId(resultSet.getLong(ORDER_USER_ID));
        order.setConstructionSiteId(resultSet.getLong(ORDER_CONSTRUCTION_SITE_ID));
        order.setDateTaken(resultSet.getDate(ORDER_DATE_TAKEN));
        return order;

    }

    @Override
    public List<Order> findByDate(Date date) {
        return null;
    }

    @Override
    public List<Order> findByUser(Long userId) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        final String findAllQuery = "select * from m_order";
        return namedParameterJdbcTemplate.query(findAllQuery, this::getOrderRowMapper);
    }

    @Override
    public Order findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Order save(Order entity) {
        return null;
    }

    @Override
    public Order update(Order entity) {
        return null;
    }
}
