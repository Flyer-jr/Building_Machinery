package com.fly.controller.convertor.user;

import com.fly.controller.requests.user.UserCreateRequest;
import com.fly.repository.entities.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor


public class UserCreateRequestConverter extends UserRequestConverter<UserCreateRequest, User> {

  private final PasswordEncoder passwordEncoder;

  @Override
  public User convert(UserCreateRequest request) {
    User user = new User();
    user.setLogin(request.getLogin());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    return doConvert(user, request);
  }
}
