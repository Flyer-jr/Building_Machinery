package com.fly.controller.controllers;

import com.fly.controller.requests.user.UserCreateRequest;
import com.fly.servise.MailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

  private final MailSender mailSender;

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public void sendMail(@RequestBody @Valid String email) {
    mailSender.sendMail(email);
  }
}
