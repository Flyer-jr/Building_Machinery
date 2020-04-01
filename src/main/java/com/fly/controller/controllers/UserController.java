package com.fly.controller.controllers;

import com.fly.controller.requests.user.UserCreateRequest;
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

@Controller
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

  private final UserRepository userRepository;

  @Autowired
  @Qualifier(value = "mvcConversionService")
  private ConversionService conversionService;

  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<User>> getUserList() {
    return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
  }

  @ApiOperation(value = "Get user from server by id")
  @ApiResponses({
    @ApiResponse(code = 200, message = "Successful getting user"),
    @ApiResponse(code = 400, message = "Invalid User ID supplied"),
    @ApiResponse(code = 401, message = "Lol kek"),
    @ApiResponse(code = 404, message = "User was not found"),
    @ApiResponse(code = 500, message = "Server error, something wrong")
  })
  @GetMapping(value = "/{id}")
  public ResponseEntity<User> getUserById(@ApiParam("User Path Id") @PathVariable String id) {
    User user =
        userRepository
            .findById(Long.valueOf(id))
            .orElseThrow(() -> new EntityNotFoundException(User.class, id));
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @PostMapping
  @Transactional
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<User> createUser(@RequestBody @Valid UserCreateRequest request) {
    User convertedUser = conversionService.convert(request, User.class);
    return new ResponseEntity<>(userRepository.saveAndFlush(convertedUser), CREATED);
  }

  @DeleteMapping(value = "delete/{id}")
  @Transactional
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Long> deleteUserById (@ApiParam("User Path Id")  @PathVariable("id") Long id){
    userRepository.deleteById(id);
    return new ResponseEntity<>(id, HttpStatus.OK);
  }
}