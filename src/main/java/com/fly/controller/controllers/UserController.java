package com.fly.controller.controllers;

import com.fly.controller.requests.user.UserCreateRequest;
import com.fly.controller.requests.user.UserUpdateRequest;
import com.fly.exceptions.EntityNotFoundException;
import com.fly.repository.dao.UserRepository;
import com.fly.repository.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

  private final UserRepository userRepository;

  @Autowired
  @Qualifier(value = "mvcConversionService")
  private ConversionService conversionService;

  @ApiOperation(value = "Get all users from server")
  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<User>> getUserList() {
    return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
  }

  @ApiOperation(value = "Get user from server by name")
  @GetMapping(value = "/search/{name}")
  public ResponseEntity<List<User>> getUserByName(@PathVariable  String name) {
   return new ResponseEntity<>(userRepository.findUsersByFirstName(name), HttpStatus.OK);
  }


  @ApiOperation(value = "Get user from server by id")
  @GetMapping(value = "/{id}")
  public ResponseEntity<User> getUserById(@ApiParam("User Path Id") @PathVariable String id) {
    User user =
            userRepository
                    .findById(Long.valueOf(id))
                    .orElseThrow(() -> new EntityNotFoundException(User.class, id));
    return new ResponseEntity<>(user, HttpStatus.OK);
  }
  @ApiOperation(value = "Create user")
  @PostMapping
  @Transactional
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<User> createUser(@ModelAttribute @Valid UserCreateRequest request) {
    User convertedUser = conversionService.convert(request, User.class);
    return new ResponseEntity<>(userRepository.saveAndFlush(convertedUser), CREATED);
  }

  @ApiOperation(value = "Delete user from server by id")
  @DeleteMapping(value = "delete/{id}")
  @Transactional
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<String> deleteUserById(
      @ApiParam("User Path Id") @PathVariable("id") String id) {
    userRepository.deleteById(Long.valueOf(id));
    return new ResponseEntity<>(id, HttpStatus.OK);
  }

  @PostMapping("update/{id}")
  @Transactional
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Long> updateUserById(@ModelAttribute @Valid UserUpdateRequest request) {
    User convertedUser = conversionService.convert(request, User.class);
    return new ResponseEntity(userRepository.save(convertedUser), HttpStatus.OK);
  }
}
