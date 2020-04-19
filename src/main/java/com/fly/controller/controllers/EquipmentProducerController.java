package com.fly.controller.controllers;

import com.fly.controller.requests.equipment.EquipmentCreateRequest;
import com.fly.controller.requests.equipmentProducer.EquipmentProducerUpdateRequest;
import com.fly.exceptions.EntityNotFoundException;
import com.fly.repository.dao.EquipmentProducerRepository;
import com.fly.repository.dto.EntityListDTO;
import com.fly.repository.entities.EquipmentProducer;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/equipmentProducer")
public class EquipmentProducerController {

  @Autowired
  @Qualifier(value = "mvcConversionService")
  private ConversionService conversionService;

  private final EquipmentProducerRepository equipmentProducerRepository;

  @ApiOperation(value = "Get all equipment producers from server ")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  @ApiModelProperty
  public Page<EquipmentProducer> pageableList(@PageableDefault(value = 20) Pageable pageable) {
    return equipmentProducerRepository.findAll(pageable);
  }

  @ApiOperation(value = "Get all equipment producers from server using DTO for frontend checkboxes")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @GetMapping("/allAsList")
  @ResponseStatus(HttpStatus.OK)
  public List<EntityListDTO> list() {
    return equipmentProducerRepository.findAll().stream()
        .map(entity -> new EntityListDTO(entity.getId(), entity.getName()))
        .collect(Collectors.toList());
  }

  @ApiOperation(value = "Get equipment producer from server by id")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @GetMapping(value = "/{id}")
  public ResponseEntity<EquipmentProducer> getProducerById(
      @ApiParam("Equipment Producer Id") @PathVariable String id) {
    EquipmentProducer equipmentProducer =
        equipmentProducerRepository
            .findById(Long.valueOf(id))
            .orElseThrow(() -> new EntityNotFoundException(EquipmentProducer.class, id));
    return new ResponseEntity<>(equipmentProducer, HttpStatus.OK);
  }

  @ApiOperation(value = "Save new equipment producer to server")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @PostMapping
  @Transactional
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<EquipmentProducer> createEquipmentProducer(
      @ModelAttribute @Valid EquipmentCreateRequest request) {
    EquipmentProducer convertedProducer =
        conversionService.convert(request, EquipmentProducer.class);
    return new ResponseEntity<>(
        equipmentProducerRepository.saveAndFlush(convertedProducer), CREATED);
  }

  @ApiOperation(value = "Update equipment producer at server")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @PutMapping
  @Transactional
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<EquipmentProducer> updateEquipmentProducer(
      @ModelAttribute @Valid EquipmentProducerUpdateRequest request) {
    EquipmentProducer convertedProducer =
        conversionService.convert(request, EquipmentProducer.class);
    return new ResponseEntity<>(
        equipmentProducerRepository.saveAndFlush(convertedProducer), HttpStatus.OK);
  }

  @ApiOperation(value = "Delete equipment producer from server")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @DeleteMapping(value = "delete/{id}")
  @Transactional
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<String> deleteProducerById(
      @ApiParam("EquipmentProducer Id") @PathVariable("id") String id) {
    equipmentProducerRepository.deleteById(Long.valueOf(id));
    return new ResponseEntity<>(id, HttpStatus.OK);
  }
}
