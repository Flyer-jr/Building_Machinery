package com.fly.controller.convertor.user;

import com.fly.controller.convertor.EntityConverter;
import com.fly.controller.requests.user.UserCreateRequest;
import com.fly.repository.entities.Role;
import com.fly.repository.entities.User;



public abstract class UserRequestConverter<S, T> extends EntityConverter<S, T> {

    private static final Role DEFAULT_ROLE =
            Role.builder()
                    .roleId(2L)
                    .roleName("ROLE_USER")
                    .build();

    protected User doConvert(User user, UserCreateRequest request) {

        user.setFirstName(request.getFirstName());
        user.setSecondName(request.getSecondName().toLowerCase());
        user.setPost(request.getPost());
        user.setActual(Boolean.TRUE);
        user.setRole(DEFAULT_ROLE);

        return user;
    }
}
