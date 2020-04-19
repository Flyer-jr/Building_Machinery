package com.fly.controller.controllers;

import com.fly.controller.requests.constructionSite.ConstructionSiteUpdateRequest;
import com.fly.exceptions.EntityNotFoundException;
import com.fly.repository.dao.ConstructionSiteRepository;
import com.fly.repository.dto.EntityListDTO;
import com.fly.repository.entities.ConstructionSite;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
  @ApiImplicitParams(
          @ApiImplicitParam(
                  name = "Auth-Token",
                  value = "Auth-Token",
                  required = true,
                  dataType = "String",
                  paramType = "Header"))
  @Secured({"ROLE_ADMIN", "ROLE_USER"})
  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<ConstructionSite>> getSiteList() {
    return new ResponseEntity<>(constructionSiteRepository.findAll(), HttpStatus.OK);
  }

  @ApiOperation(value = "Get all Construction Site from server using DTO for checkboxes")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @Secured({"ROLE_ADMIN", "ROLE_USER"})
  @GetMapping("/allAsList")
  @ResponseStatus(HttpStatus.OK)
  public List<EntityListDTO> list() {
    return constructionSiteRepository.findAll()
            .stream()
        .map(entity -> new EntityListDTO(entity.getId(), entity.getShortName()))
        .collect(Collectors.toList());
  }

  @ApiOperation(value = "Get Construction Site from server by id")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @Secured({"ROLE_ADMIN", "ROLE_USER"})
  @GetMapping(value = "/{id}")
  public ResponseEntity<ConstructionSite> getSiteById(
      @ApiParam("Construction Site Id") @PathVariable String id) {
    ConstructionSite constructionSite =
        constructionSiteRepository
            .findById(Long.valueOf(id))
            .orElseThrow(() -> new EntityNotFoundException(ConstructionSite.class, id));
    return new ResponseEntity<>(constructionSite, HttpStatus.OK);
  }

  @ApiOperation(value = "Update Construction Site at server")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @PutMapping
  @Transactional(rollbackOn = Exception.class)
  @ResponseStatus(HttpStatus.OK)
  @Secured({"ROLE_ADMIN", "ROLE_USER"})
  public ResponseEntity<ConstructionSite> updateSite(
      @ModelAttribute @Valid ConstructionSiteUpdateRequest request) {
    ConstructionSite convertedSite = conversionService.convert(request, ConstructionSite.class);
    return new ResponseEntity<>(
        constructionSiteRepository.saveAndFlush(convertedSite), HttpStatus.OK);
  }

  @ApiOperation(value = "Delete ConstructionSite from server by id")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "Auth-Token", value = "Auth-Token", required = true, dataType = "String", paramType = "Header"))
  @DeleteMapping(value = "delete/{id}")
  @Secured("ROLE_ADMIN")
  @Transactional(rollbackOn = Exception.class)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<String> deleteConstructionSiteById(
      @ApiParam("Construction Site Id") @PathVariable("id") String id) {
    constructionSiteRepository.deleteById(Long.valueOf(id));
    return new ResponseEntity<>(id, HttpStatus.OK);
  }
}
