package com.fly.controller.convert;

import com.fly.controller.requests.UserCreateRequest;
import com.fly.repository.entities.User;



public abstract class UserRequestConverter<S, T> extends EntityConverter<S, T> {

    protected User doConvert(User user, UserCreateRequest request) {

        user.setFirstName(request.getFirstName());
        user.setSecondName(request.getSecondName());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPassword(request.getPassword());
        user.setPost(request.getPost());

        return user;
    }
}
