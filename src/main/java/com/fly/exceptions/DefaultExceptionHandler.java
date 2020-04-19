package com.fly.exceptions;

import com.fly.exceptions.messages.ErrorMessage;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
@Slf4j
public class DefaultExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorMessage> handleNoSuchEntityException(
          MethodArgumentNotValidException e) {
    log.error(e.getMessage(), e);
    return new ResponseEntity<>(new ErrorMessage(e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @ExceptionHandler(AccessDeniedException.class)
  public ResponseEntity<ErrorMessage> handleAccessException(AccessDeniedException e) {
    log.error(e.getMessage(), e);
    return new ResponseEntity<>(new ErrorMessage(e.getMessage()), HttpStatus.FORBIDDEN);
  }

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<ErrorMessage> handleNoSuchEntityException(EntityNotFoundException e) {
    log.error(e.getMessage(), e);
    return new ResponseEntity<>(new ErrorMessage(e.getMessage()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(AuthenticationException.class)
  public ResponseEntity<ErrorMessage> handleAuthenticationException(AuthenticationException e) {
    log.error(e.getMessage(), e);
    return new ResponseEntity<>(new ErrorMessage(e.getMessage()), HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler({
          UnsupportedJwtException.class,
          MalformedJwtException.class,
          SignatureException.class,
          ExpiredJwtException.class,
          IllegalArgumentException.class
  })
  public ResponseEntity<ErrorMessage> handleTokenProcessingException(AuthenticationException e) {
    log.error(e.getMessage(), e);
    return new ResponseEntity<>(new ErrorMessage(e.getMessage()), HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler(NullPointerException.class)
  public ResponseEntity<ErrorMessage> handleNPException(NullPointerException e) {
    log.error(e.getMessage(), e);

    return new ResponseEntity<>(new ErrorMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorMessage> handleOthersException(Exception e) {
    log.error(e.getMessage(), e);
    return new ResponseEntity<>(new ErrorMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
