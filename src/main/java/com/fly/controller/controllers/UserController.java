package com.fly.controller.controllers;

import com.fly.controller.requests.user.UserCreateRequest;
import com.fly.controller.requests.user.UserUpdateRequest;
import com.fly.exceptions.EntityNotFoundException;
import com.fly.repository.dao.UserRepository;
import com.fly.repository.entities.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  @Secured({"ROLE_ADMIN", "ROLE_USER"})
  public ResponseEntity<List<User>> getUserList() {
    return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
  }

  @ApiOperation(value = "Get user from server by name")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @GetMapping(value = "/search/{name}")
  @Secured("ROLE_ADMIN")
  public ResponseEntity<User> getUserByName(@PathVariable String name) {
    return new ResponseEntity<>(userRepository.findUserBySecondName(name.toLowerCase()), HttpStatus.OK);
  }

  @ApiOperation(value = "Get user from server by id")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @GetMapping(value = "/{id}")
  @Secured("ROLE_ADMIN")
  public ResponseEntity<User> getUserById(@ApiParam("User Path Id") @PathVariable String id) {
    User user =
        userRepository
            .findById(Long.valueOf(id))
            .orElseThrow(() -> new EntityNotFoundException(User.class, id));
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @ApiOperation(value = "Create user")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @PostMapping
  @Transactional(rollbackFor = Exception.class)
  @ResponseStatus(HttpStatus.OK)
  @Secured("ROLE_ADMIN")
  public ResponseEntity<User> createUser(@ModelAttribute @Valid UserCreateRequest request) {
    User convertedUser = conversionService.convert(request, User.class);
    return new ResponseEntity<>(userRepository.saveAndFlush(convertedUser), CREATED);
  }

  @ApiOperation(value = "Delete user from server by id")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @DeleteMapping(value = "delete/{id}")
  @Transactional(rollbackFor = Exception.class)
  @ResponseStatus(HttpStatus.OK)
  @Secured("ROLE_ADMIN")
  public ResponseEntity<String> deleteUserById(
      @ApiParam("User Path Id") @PathVariable("id") String id) {
    userRepository.deleteById(Long.valueOf(id));
    return new ResponseEntity<>(id, HttpStatus.OK);
  }

  @ApiOperation(value = "Update user at server by id")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @PostMapping("update/{id}")
  @Transactional(rollbackFor = Exception.class)
  @ResponseStatus(HttpStatus.OK)
  @Secured({"ROLE_ADMIN", "ROLE_USER"})
  public ResponseEntity<Long> updateUserById(@ModelAttribute @Valid UserUpdateRequest request) {
    User convertedUser = conversionService.convert(request, User.class);
    return new ResponseEntity(userRepository.save(convertedUser), HttpStatus.OK);
  }
}
