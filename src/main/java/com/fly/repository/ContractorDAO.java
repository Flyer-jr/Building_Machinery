package com.fly.repository;

import com.fly.repository.entities.Contractor;

public interface ContractorDAO extends GenericDAO<Contractor, Long> {
    Contractor findByShortName(String shortName);

}
