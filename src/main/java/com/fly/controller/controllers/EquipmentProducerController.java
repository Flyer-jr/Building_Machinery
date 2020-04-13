package com.fly.controller.controllers;

import com.fly.repository.dao.EquipmentProducerRepository;
import com.fly.repository.dao.EquipmentRepository;
import com.fly.repository.dto.EntityListDTO;
import com.fly.repository.dto.ListEquipmentDTO;
import com.fly.repository.entities.Equipment;
import com.fly.repository.entities.EquipmentProducer;
import io.swagger.annotations.ApiModelProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/equipmentProducer")
public class EquipmentProducerController {

  private final EquipmentProducerRepository equipmentProducerRepository;

  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  @ApiModelProperty
  public Page<EquipmentProducer> pageableList(@PageableDefault(value = 20) Pageable pageable) {
    return equipmentProducerRepository.findAll(pageable);
  }

  @GetMapping("/allAsList")
  @ResponseStatus(HttpStatus.OK)
  public List<EntityListDTO> list() {
    return equipmentProducerRepository.findAll().stream()
        .map(entity -> new EntityListDTO(entity.getId(), entity.getName()))
        .collect(Collectors.toList());
  }
}
