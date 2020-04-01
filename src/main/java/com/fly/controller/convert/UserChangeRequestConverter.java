package com.fly.controller.convert;

import com.fly.controller.requests.UserUpdateRequest;
import com.fly.exceptions.EntityNotFoundException;
import com.fly.repository.entities.User;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

@Component
public class UserChangeRequestConverter extends UserRequestConverter<UserUpdateRequest, User> {

  @Override
  public User convert(UserUpdateRequest request) {
    User user =
        ofNullable(entityManager.find(User.class, request.getUserId()))
            .orElseThrow(() -> new EntityNotFoundException(User.class, request.getUserId()));
    return doConvert(user, request);
  }
}
