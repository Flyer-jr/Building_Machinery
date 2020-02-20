package com.fly.repository.impl;

import com.fly.repository.dao.OrderDAO;
import com.fly.repository.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

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
    public List<Order> findOrderByDate(Date date) {

        final String findByDate = "select * from m_order where date_taken = :dateTaken";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("dateTaken", date);

        return namedParameterJdbcTemplate.query(findByDate, parameterSource, this::getOrderRowMapper);
    }

    @Override
    public List<Order> findOrderByUser(Long userId) {

        final String findByUser = "select * from m_order where user_id = :userId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("userId", userId);

        return namedParameterJdbcTemplate.query(findByUser, parameterSource, this::getOrderRowMapper);
    }

    @Override
    public List<Order> findAll() {
        final String findAllQuery = "select * from m_order";
        return namedParameterJdbcTemplate.query(findAllQuery, this::getOrderRowMapper);
    }

    @Override
    public Order findById(Long id) {

        final String findById = "select * from m_order where id = :orderId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("orderId", id);

        return namedParameterJdbcTemplate.queryForObject(findById,parameterSource, this::getOrderRowMapper);
    }

    @Override
    public void delete(Long id) {

        final String deleteQuery = "DELETE from m_order where id = :orderId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("orderId", id);
        namedParameterJdbcTemplate.update(deleteQuery,parameterSource);

    }

    @Override
    public Order save(Order entity) {

        final String saveQuery = "INSERT INTO m_order (user_id, consruction_site_id, date_taken)" +
                "VALUES (:userId, :constructionSiteId, :dateTaken)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("userId", entity.getUserId());
        parameterSource.addValue("constructionSiteId", entity.getConstructionSiteId());
        parameterSource.addValue("dateTaken", entity.getDateTaken());

        namedParameterJdbcTemplate.update(saveQuery,parameterSource,keyHolder);

        long createdOrderId = Objects.requireNonNull(keyHolder.getKey().longValue());

        return findById(createdOrderId);
    }

    @Override
    public Order update(Order entity) {

        final String updateQuery = "UPDATE m_order set user_id = :userID, construction_site_id = :constructionSiteId," +
                " date_taken = dateTaken where id = :Id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("userId", entity.getUserId());
        parameterSource.addValue("constructionSiteId", entity.getConstructionSiteId());
        parameterSource.addValue("dateTaken", entity.getDateTaken());
        parameterSource.addValue("id", entity.getId());

        namedParameterJdbcTemplate.update(updateQuery, parameterSource);
        return findById(entity.getId());
    }
}
