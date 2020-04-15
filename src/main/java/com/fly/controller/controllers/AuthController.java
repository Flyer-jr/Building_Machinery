package com.fly.controller.controllers;

import com.fly.configuration.security.jwt.JwtTokenProvider;
import com.fly.controller.requests.authentication.AuthenticationRequest;
import com.fly.controller.response.AuthResponse;
import com.fly.service.MailSender;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;


@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {


  private final JwtTokenProvider jwtTokenProvider;
  private final AuthenticationManager authenticationManager;
  private final MailSender mailSender;


//  @PostMapping
//  @ResponseStatus(HttpStatus.OK)
//  public void sendMail(@RequestBody @Valid String email) {
//    mailSender.sendMail(email);
//  }

  @ApiOperation(value = " LogIn and create Token")
  @PostMapping
  public ResponseEntity<AuthResponse> logIn (@ModelAttribute @Valid AuthenticationRequest request){
    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getLogin(),
                    request.getPassword()
            )
    );
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String authToken = jwtTokenProvider.generateToken(authentication);




    return ResponseEntity.ok(AuthResponse
            .builder()
            .login(request.getLogin())
            .authToken(authToken)
            .build());
  }




}
