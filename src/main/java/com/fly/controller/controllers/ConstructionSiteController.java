package com.fly.controller.controllers;

import com.fly.exceptions.EntityNotFoundException;
import com.fly.repository.dao.ConstructionSiteRepository;
import com.fly.repository.dto.EntityListDTO;
import com.fly.repository.dto.ListEquipmentDTO;
import com.fly.repository.entities.ConstructionSite;
import com.fly.repository.entities.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/construction_site")
public class ConstructionSiteController {

  private final ConstructionSiteRepository constructionSiteRepository;

  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<ConstructionSite>> getSiteList() {
    return new ResponseEntity<>(constructionSiteRepository.findAll(), HttpStatus.OK);
  }

  @GetMapping("/allAsList")
  @ResponseStatus(HttpStatus.OK)
  public List<EntityListDTO> list() {
    return constructionSiteRepository.findAll().stream()
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
}
