package com.fly.repository.dao;

import com.fly.repository.entities.Contractor;

public interface ContractorDAO extends GenericDAO<Contractor, Long> {
    Contractor findContractorByShortName(String shortName);

}
