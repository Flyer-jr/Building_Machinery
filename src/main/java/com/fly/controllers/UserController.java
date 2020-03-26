package com.fly.controllers;

import com.fly.repository.hibernate.HibernateUser;
import com.fly.repository.hibernateDAO.HibernateUserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final HibernateUserDAO hibernateUser;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<HibernateUser>> getUserList() {
        return new ResponseEntity<>(hibernateUser.findAll(), HttpStatus.OK);
    }

}
