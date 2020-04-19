package com.fly.service.security;

import com.fly.configuration.security.jwt.JwtTokenUtils;
import com.fly.controller.requests.authentication.AuthenticationRequest;
import com.fly.controller.requests.user.UserCreateRequest;
import com.fly.exceptions.UserRegistrationException;
import com.fly.repository.dao.NotConfirmedUsersRepository;
import com.fly.repository.dao.UserRepository;
import com.fly.repository.entities.NotConfirmedUser;
import com.fly.repository.entities.User;
import com.fly.service.mail.MailMessageCreator;
import com.fly.service.mail.MailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistrationService {

  private final JwtTokenUtils tokenProvider;
  private final NotConfirmedUsersRepository notConfirmedUsersRepository;
  private final UserRepository userRepository;
  private final MailMessageCreator messageCreator;
  private final MailSender mailSender;

  @Autowired
  @Qualifier("mvcConversionService")
  private ConversionService conversionService;

  public void notConfirmedRegistration(UserCreateRequest request) {

    if (userRepository.findUserByLogin(request.getLogin().toLowerCase()).isPresent()
            || userRepository.findUserByEmail(request.getEmail().toLowerCase()).isPresent()) {
      throw new UserRegistrationException("User already exists");
    } else if (notConfirmedUsersRepository
            .findNotConfirmedUserByLogin(request.getLogin().toLowerCase())
            .isPresent()
            || notConfirmedUsersRepository
            .findNotConfirmedUserByEmail(request.getEmail().toLowerCase())
            .isPresent()) {
      throw new UserRegistrationException("User exists but not confirmed");
    } else {

      NotConfirmedUser notConfirmedUser = new NotConfirmedUser();
      String token = tokenProvider.generateConfirmationToken(request);
      BeanUtils.copyProperties(request, notConfirmedUser, "id", "confirmationToken");
      notConfirmedUser.setConfirmationToken(token);
      notConfirmedUser.setLogin(notConfirmedUser.getLogin().toLowerCase());
      notConfirmedUser.setEmail(notConfirmedUser.getEmail().toLowerCase());
      notConfirmedUsersRepository.saveAndFlush(notConfirmedUser);
      mailSender.sendMail(request.getEmail(), messageCreator.confirmationMessageCreate(token));
    }
  }

  public AuthenticationRequest confirm(String token) {

    AuthenticationRequest request = new AuthenticationRequest();
    if (StringUtils.hasText(token) && tokenProvider.validateToken(token)) {

      String login = tokenProvider.getUsernameFromToken(token);

      Optional<NotConfirmedUser> notConfirmedUser =
              notConfirmedUsersRepository.findNotConfirmedUserByLogin(login.toLowerCase());
      UserCreateRequest userCreateRequest = new UserCreateRequest();
      BeanUtils.copyProperties(notConfirmedUser.get(), userCreateRequest, "id", "confirmationToken");
      notConfirmedUsersRepository.delete(notConfirmedUser.get());
      userRepository.saveAndFlush(
              Objects.requireNonNull(conversionService.convert(userCreateRequest, User.class)));
      request.setLogin(notConfirmedUser.get().getLogin());
      request.setPassword(notConfirmedUser.get().getPassword());
    }
    return request;
  }
}
