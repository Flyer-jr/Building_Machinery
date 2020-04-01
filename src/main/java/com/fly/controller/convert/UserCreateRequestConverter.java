package com.fly.controller.convert;

import com.fly.controller.requests.UserCreateRequest;
import com.fly.repository.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserCreateRequestConverter extends UserRequestConverter<UserCreateRequest, User> {

  @Override
  public User convert(UserCreateRequest request) {
    User user = new User();
    return doConvert(user, request);
  }
}
