package com.fly.controller.controllers;

import com.fly.repository.dao.ContractorRepository;
import com.fly.repository.entities.Contractor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/contractors")
public class ContractorController {

  private final ContractorRepository contractorRepository;

  @RequestMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<Contractor>> getContractorList() {
    return new ResponseEntity<>(contractorRepository.findAll(), HttpStatus.OK);
  }
}
