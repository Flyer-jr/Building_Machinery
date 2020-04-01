package com.fly.repository.dao;

import com.fly.repository.entities.ConstructionSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructionSiteRepository
    extends JpaRepository<ConstructionSite, Long>, CrudRepository<ConstructionSite, Long> {
  ConstructionSite findSiteByShortName(String shortName);
}
