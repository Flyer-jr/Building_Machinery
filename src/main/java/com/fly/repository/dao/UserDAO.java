package com.fly.repository.dao;

import com.fly.repository.entities.User;
import com.fly.repository.hibernate.HibernateUser;

import java.sql.Date;
import java.util.List;

public interface UserDAO extends GenericDAO<User, Long> {

    void dissmissUser(Long id, Date date);
}
