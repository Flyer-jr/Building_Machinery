package com.fly.repository;

import com.fly.repository.entities.ConstructionSite;

public interface ConstructionSiteDAO extends GenericDAO<ConstructionSite, Long> {
    ConstructionSite findByShortName(String shortName);




}
