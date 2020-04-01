package com.fly.controllers;


import com.fly.repository.hibernate.HibernateEquipment;
import com.fly.repository.hibernateDAO.HibernateEquipmentDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    private final HibernateEquipmentDAO equipment;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<List<HibernateEquipment>> getEquipmentList(){
        return new ResponseEntity<>(equipment.findAll(),HttpStatus.OK);
    }

}
