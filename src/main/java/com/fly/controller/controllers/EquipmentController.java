package com.fly.controller.controllers;

import com.fly.repository.dao.EquipmentRepository;
import com.fly.repository.dto.ListEquipmentDTO;

import com.fly.repository.entities.Equipment;
import io.swagger.annotations.ApiModelProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/equipment")
public class EquipmentController {

  private final EquipmentRepository equipmentRepository;

  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  @ApiModelProperty
  public Page<Equipment> pageableList(@PageableDefault(value = 20) Pageable pageable) {
    return equipmentRepository.findAll(pageable);
  }
  @GetMapping("/allAsList")
  @ResponseStatus(HttpStatus.OK)
  public List<ListEquipmentDTO> list() {
    return equipmentRepository.findAll()
            .stream()
            .map(entity -> new ListEquipmentDTO(entity.getStoreNumber(), entity.getModel()))
            .collect(Collectors.toList());
  }

}
