package com.fly.service.constructionSite;

import com.fly.exceptions.EntityNotFoundException;
import com.fly.repository.dao.ConstructionSiteRepository;
import jdk.jfr.Frequency;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConstructionSiteValidationService {

    private final ConstructionSiteRepository repository;

 public boolean siteValid(String siteName) {
        if (repository.findSiteByShortName(siteName) == null) {
            throw new EntityNotFoundException(
                    String.format("No site found with field '%s'.", siteName));}
            else return Boolean.TRUE;

        }


    }

