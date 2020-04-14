package com.fly.controller.controllers;

import com.fly.controller.requests.constructionSite.ConstructionSiteCreateRequest;
import com.fly.controller.requests.constructionSite.ConstructionSiteUpdateRequest;
import com.fly.exceptions.EntityNotFoundException;
import com.fly.repository.dao.ConstructionSiteRepository;
import com.fly.repository.dto.EntityListDTO;
import com.fly.repository.entities.ConstructionSite;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@RequestMapping("/construction_site")
public class ConstructionSiteController {

  private final ConstructionSiteRepository constructionSiteRepository;

  @Autowired
  @Qualifier(value = "mvcConversionService")
  private ConversionService conversionService;

  @ApiOperation(value = "Get all Construction Sites from server")
  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<ConstructionSite>> getSiteList() {
    return new ResponseEntity<>(constructionSiteRepository.findAll(), HttpStatus.OK);
  }

  @ApiOperation(value = "Get all Construction Site from server using DTO for checkboxes")
  @GetMapping("/allAsList")
  @ResponseStatus(HttpStatus.OK)
  public List<EntityListDTO> list() {
    return constructionSiteRepository.findAll()
            .stream()
        .map(entity -> new EntityListDTO(entity.getId(), entity.getShortName()))
        .collect(Collectors.toList());
  }

  @ApiOperation(value = "Get Construction Site from server by id")
  @GetMapping(value = "/{id}")
  public ResponseEntity<ConstructionSite> getSiteById(
      @ApiParam("Construction Site Id") @PathVariable String id) {
    ConstructionSite constructionSite =
        constructionSiteRepository
            .findById(Long.valueOf(id))
            .orElseThrow(() -> new EntityNotFoundException(ConstructionSite.class, id));
    return new ResponseEntity<>(constructionSite, HttpStatus.OK);
  }

  @ApiOperation(value = "Save new Construction Site to server")
  @PostMapping
  @Transactional
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<ConstructionSite> createConstructionSite(
      @ModelAttribute @Valid ConstructionSiteCreateRequest request) {
    ConstructionSite convertedSite = conversionService.convert(request, ConstructionSite.class);
    return new ResponseEntity<>(constructionSiteRepository.saveAndFlush(convertedSite), CREATED);
  }

  @ApiOperation(value = "Update Construction Site at server")
  @PutMapping
  @Transactional
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<ConstructionSite> updateSite(
      @ModelAttribute @Valid ConstructionSiteUpdateRequest request) {
    ConstructionSite convertedSite = conversionService.convert(request, ConstructionSite.class);
    return new ResponseEntity<>(
        constructionSiteRepository.saveAndFlush(convertedSite), HttpStatus.OK);
  }

  @ApiOperation(value = "Delete ConstructionSite from server by id")
  @DeleteMapping(value = "delete/{id}")
  @Transactional
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<String> deleteConstructionSiteById(
      @ApiParam("Construction Site Id") @PathVariable("id") String id) {
    constructionSiteRepository.deleteById(Long.valueOf(id));
    return new ResponseEntity<>(id, HttpStatus.OK);
  }
}
