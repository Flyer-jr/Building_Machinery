package com.fly.repository.dao;

import com.fly.repository.entities.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractorRepository
    extends JpaRepository<Contractor, Long>, CrudRepository<Contractor, Long> {
  Contractor findContractorByShortName(String shortName);
}
