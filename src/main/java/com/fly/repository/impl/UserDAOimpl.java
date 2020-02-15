package com.fly.repository.impl;

import com.fly.repository.dao.UserDAO;
import com.fly.repository.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@Repository
public class UserDAOimpl implements UserDAO {

    public static final String USER_ID="id";
    public static final String USER_FIRST_NAME="first_name";
    public static final String USER_SECOND_NAME="second_name";
    public static final String USER_PHONE_NUMBER="phone_number";
    public static final String USER_PASSWORD="password";
    public static final String USER_POST="post";
    public static final String USER_ACTUAL="actual";
    public static final String USER_DATE_OF_DISMISS="date_of_dissmiss";

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
        user.setDateOfDismiss(resultSet.getDate(USER_DATE_OF_DISMISS));
        return user;

    }

    @Override
    public List<User> findAll() {
        final String findAllQuery = "select * from m_user";
        return namedParameterJdbcTemplate.query(findAllQuery, this::getUserRowMapper);
    }

    @Override
    public User findById(Long id) {
        final String findByID = "select * from m_user where id = :userId";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("userId", id);

        return namedParameterJdbcTemplate.queryForObject(findByID, parameterSource, this::getUserRowMapper);
    }

    @Override
    public void delete(Long id) {
        final String delete = "delete from m_user where id = :userId";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("userId", id);

        namedParameterJdbcTemplate.update(delete,parameterSource);

    }

    @Override
    public User save(User entity) {
        final String createQuery = "INSERT INTO m_user (first_name, second_name, phone_number, password, post, actual, date_of_dissmiss)" +
                "VALUES (:userFirstName, :userSecondName, :userPhoneNumber, :userPassword, :userPost, :userActual, :userDateOfDismiss)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        sqlParameterSource.addValue("userFirstName", entity.getFirstName());
        sqlParameterSource.addValue("userSecondName", entity.getSecondName());
        sqlParameterSource.addValue("userPhoneNumber", entity.getPhoneNumber());
        sqlParameterSource.addValue("userPassword", entity.getPassword());
        sqlParameterSource.addValue("userPost", entity.getPost());
        sqlParameterSource.addValue("userActual", entity.isActual());
        sqlParameterSource.addValue("userDateOfDismiss", entity.getDateOfDismiss());

        namedParameterJdbcTemplate.update(createQuery, sqlParameterSource, keyHolder);

        long createdUserId = Objects.requireNonNull(keyHolder.getKey().longValue());

        return findById(createdUserId);
    }

    @Override
    public User update(User entity) {
        final String updateQuery = "UPDATE m_user set first_name = :userName, second_name = :userSecondName," +
                "phone_number = :userPhoneNumber, password = :userPassword, post = :userPost," +
                "actual = :userActual, date_of_dissmiss = :useDateOfDismiss where id = :userId";

        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        sqlParameterSource.addValue("userId", entity.getId());
        sqlParameterSource.addValue("userFirstName", entity.getFirstName());
        sqlParameterSource.addValue("userSecondName", entity.getSecondName());
        sqlParameterSource.addValue("userPhoneNumber", entity.getPhoneNumber());
        sqlParameterSource.addValue("userPassword", entity.getPassword());
        sqlParameterSource.addValue("userPost", entity.getPost());
        sqlParameterSource.addValue("userActual", entity.isActual());
        sqlParameterSource.addValue("userDateOfDismiss", entity.getDateOfDismiss());

        namedParameterJdbcTemplate.update(updateQuery, sqlParameterSource);
        return findById(entity.getId());
    }

    @Override
    public void dissmiss(Long id, Date date) {
        User user = new User();
        user = findById(id);
        user.setDateOfDismiss(date);
        user.setActual(Boolean.FALSE);
        user = update(findById(id));

    }
}
