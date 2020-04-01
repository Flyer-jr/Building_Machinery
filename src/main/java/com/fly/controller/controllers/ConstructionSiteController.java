package com.fly.controller.controllers;

import com.fly.repository.dao.ConstructionSiteRepository;
import com.fly.repository.entities.ConstructionSite;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/construction_site")
public class ConstructionSiteController {

  private final ConstructionSiteRepository constructionSiteRepository;

  @GetMapping("/allSites")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<ConstructionSite>> getSiteList() {
    return new ResponseEntity<>(constructionSiteRepository.findAll(), HttpStatus.OK);
  }
}
