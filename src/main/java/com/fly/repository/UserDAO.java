package com.fly.repository;

import com.fly.repository.entities.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User, Long> {
    List<Long> batchUpdate(List<User> users);

    void dissmiss(Long id);



}
