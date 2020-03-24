package com.fly.controllers;

import com.fly.repository.hibernate.HibernateConstructionSite;
import com.fly.repository.hibernate.HibernateUser;
import com.fly.repository.hibernateDAO.HibernateConstructionSiteDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/construction_site")
public class ConstructionSiteController {

    private final HibernateConstructionSiteDAO constructionSite;


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<HibernateConstructionSite>> getSitesHibernate() {
        return new ResponseEntity<>(constructionSite.findAll(), HttpStatus.OK);
    }

}
