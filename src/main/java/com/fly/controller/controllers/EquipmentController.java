package com.fly.controller.controllers;

import com.fly.controller.requests.equipment.EquipmentCreateRequest;
import com.fly.controller.requests.equipment.EquipmentUpdateRequest;
import com.fly.exceptions.EntityNotFoundException;
import com.fly.repository.dao.EquipmentRepository;
import com.fly.repository.dto.ListEquipmentDTO;
import com.fly.repository.entities.Equipment;
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
@RequestMapping("/equipment")
public class EquipmentController {

  private final EquipmentRepository equipmentRepository;

  @Autowired
  @Qualifier(value = "mvcConversionService")
  private ConversionService conversionService;

  @ApiOperation(value = "Get all Equipment from server")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  @ApiModelProperty
  public Page<Equipment> pageableList(@PageableDefault(value = 20) Pageable pageable) {
    return equipmentRepository.findAll(pageable);
  }

  @ApiOperation(value = "Get all Equipment from server using DTO for frontend checkboxes")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @GetMapping("/allAsList")
  @ResponseStatus(HttpStatus.OK)
  public List<ListEquipmentDTO> list() {
    return equipmentRepository.findAll().stream()
        .map(
            entity ->
                new ListEquipmentDTO(entity.getId(), entity.getStoreNumber(), entity.getModel()))
        .collect(Collectors.toList());
  }

  @ApiOperation(value = "Get Equipment from server by id")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @GetMapping(value = "/{id}")
  public ResponseEntity<Equipment> getEquipmentById(
      @ApiParam("Equipment Id") @PathVariable String id) {
    Equipment equipment =
        equipmentRepository
            .findById(Long.valueOf(id))
            .orElseThrow(() -> new EntityNotFoundException(Equipment.class, id));
    return new ResponseEntity<>(equipment, HttpStatus.OK);
  }

  @ApiOperation(value = "Save new Equipment to server")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @PostMapping
  @Transactional
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Equipment> createEquipment(
      @ModelAttribute @Valid EquipmentCreateRequest request) {
    Equipment convertedEquipment = conversionService.convert(request, Equipment.class);
    return new ResponseEntity<>(equipmentRepository.saveAndFlush(convertedEquipment), CREATED);
  }

  @ApiOperation(value = "Update Equipment at server")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @PutMapping
  @Transactional
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Equipment> updateEquipment(
      @ModelAttribute @Valid EquipmentUpdateRequest request) {
    Equipment convertedEquipment = conversionService.convert(request, Equipment.class);
    return new ResponseEntity<>(
        equipmentRepository.saveAndFlush(convertedEquipment), HttpStatus.OK);
  }

  @ApiOperation(value = "Delete Equipment from server by id")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @DeleteMapping(value = "delete/{id}")
  @Transactional
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<String> deleteEquipmentById(
      @ApiParam("Construction Site Id") @PathVariable("id") String id) {
    equipmentRepository.deleteById(Long.valueOf(id));
    return new ResponseEntity<>(id, HttpStatus.OK);
  }
}
