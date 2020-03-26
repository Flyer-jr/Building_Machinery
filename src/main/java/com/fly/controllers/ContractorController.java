package com.fly.controllers;

import com.fly.repository.hibernate.HibernateConstructionSite;
import com.fly.repository.hibernate.HibernateContractor;
import com.fly.repository.hibernateDAO.HibernateContractorDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contractors")
public class ContractorController {

    private final HibernateContractorDAO contractor;


    @RequestMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<HibernateContractor>> getContractorList() {
        return new ResponseEntity<>(contractor.findAll(), HttpStatus.OK);
    }
}
