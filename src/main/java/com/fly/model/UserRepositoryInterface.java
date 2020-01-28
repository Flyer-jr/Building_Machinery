package com.fly.model;

import com.fly.entities.User;

import java.util.List;

public interface UserRepositoryInterface {
    int save ( User user );
    List <User> findAll ();
    User findUserByLogin();
    int isRegistered(User user);
    int upDateUser(User user);

}
