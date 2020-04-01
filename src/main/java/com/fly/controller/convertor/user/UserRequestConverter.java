package com.fly.controller.convertor.user;

import com.fly.controller.convertor.EntityConverter;
import com.fly.controller.requests.user.UserCreateRequest;
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
