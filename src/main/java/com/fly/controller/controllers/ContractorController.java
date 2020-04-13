package com.fly.controller.controllers;

import com.fly.controller.requests.contractor.ContractorCreateRequest;
import com.fly.exceptions.EntityNotFoundException;
import com.fly.repository.dao.ContractorRepository;
import com.fly.repository.dto.EntityListDTO;
import com.fly.repository.dto.ListEquipmentDTO;
import com.fly.repository.entities.Contractor;
import com.fly.repository.entities.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/contractors")
public class ContractorController {

  private final ContractorRepository contractorRepository;

  @Autowired
  @Qualifier(value = "mvcConversionService")
  private ConversionService conversionService;

  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<Contractor>> getContractorList() {
    return new ResponseEntity<>(contractorRepository.findAll(), HttpStatus.OK);
  }

  @GetMapping("/allAsList")
  @ResponseStatus(HttpStatus.OK)
  public List<EntityListDTO> list() {
    return contractorRepository.findAll().stream()
        .map(entity -> new EntityListDTO(entity.getId(), entity.getShortName()))
        .collect(Collectors.toList());
  }

  @ApiOperation(value = "Get contractor from server by id")
  @GetMapping(value = "/{id}")
  public ResponseEntity<Contractor> getContractorById(
      @ApiParam("Contractor Id") @PathVariable String id) {
    Contractor contractor =
        contractorRepository
            .findById(Long.valueOf(id))
            .orElseThrow(() -> new EntityNotFoundException(User.class, id));
    return new ResponseEntity<>(contractor, HttpStatus.OK);
  }

  @PostMapping
  @Transactional
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Contractor> createContractor(
      @ModelAttribute @Valid ContractorCreateRequest request) {
    Contractor convertedContractor = conversionService.convert(request, Contractor.class);
    return new ResponseEntity<>(contractorRepository.saveAndFlush(convertedContractor), CREATED);
  }

  @DeleteMapping(value = "delete/{id}")
  @Transactional
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<String> deleteContractorById(
      @ApiParam("Contractor Id") @PathVariable("id") String id) {
    contractorRepository.deleteById(Long.valueOf(id));
    return new ResponseEntity<>(id, HttpStatus.OK);
  }
}
