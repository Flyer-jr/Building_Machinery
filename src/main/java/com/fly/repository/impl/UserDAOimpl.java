package com.fly.repository.impl;

import com.fly.repository.UserDAO;
import com.fly.repository.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDAOimpl implements UserDAO {

    public static final String USER_ID="id";
    public static final String USER_FIRST_NAME="first_name";
    public static final String USER_SECOND_NAME="second_name";
    public static final String USER_PHONE_NUMBER="phone_number";
    public static final String USER_PASSWORD="password";
    public static final String USER_POST="post";
    public static final String USER_ACTUAL="actual";
    public static final String USER_DATE_OF_DISSMISS="date_of_dissmiss";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public UserDAOimpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private User getUserRowMapper(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong(USER_ID));
        user.setFirstName(resultSet.getString(USER_FIRST_NAME));
        user.setSecondName(resultSet.getString(USER_SECOND_NAME));
        user.setPhoneNumber(resultSet.getString(USER_PHONE_NUMBER));
        user.setPassword(resultSet.getString(USER_PASSWORD));
        user.setPost(resultSet.getString(USER_POST));
        user.setActual(resultSet.getBoolean(USER_ACTUAL));
        user.setDateOfDismiss(resultSet.getDate(USER_DATE_OF_DISSMISS));
        return user;

    }

    @Override
    public List<User> findAll() {
        final String findAllQuery = "select * from m_user";
        return namedParameterJdbcTemplate.query(findAllQuery, this::getUserRowMapper);
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public List<Long> batchUpdate(List<User> users) {
        return null;
    }

    @Override
    public void dissmiss(Long id) {

    }
}
