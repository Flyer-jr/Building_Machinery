package com.fly.repository.dao;

import com.fly.repository.entities.ConstructionSite;

public interface ConstructionSiteDAO extends GenericDAO<ConstructionSite, Long> {
    ConstructionSite findByShortName(String shortName);




}
