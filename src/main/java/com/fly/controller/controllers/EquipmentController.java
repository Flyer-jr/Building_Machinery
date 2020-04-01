package com.fly.controller.controllers;

import com.fly.repository.dao.EquipmentRepository;
import com.fly.repository.entities.Equipment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/equipment")
public class EquipmentController {

  private final EquipmentRepository equipmentRepository;

  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  private ResponseEntity<List<Equipment>> getEquipmentList() {
    return new ResponseEntity<>(equipmentRepository.findAll(), HttpStatus.OK);
  }
}
