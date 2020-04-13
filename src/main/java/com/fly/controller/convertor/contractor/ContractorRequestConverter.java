package com.fly.controller.convertor.contractor;

import com.fly.controller.convertor.EntityConverter;
import com.fly.controller.requests.contractor.ContractorCreateRequest;
import com.fly.repository.entities.Contractor;

public abstract class ContractorRequestConverter<S, T> extends EntityConverter<S, T> {

  protected Contractor doConvert(Contractor contractor, ContractorCreateRequest request) {

    contractor.setFullName(request.getFullName());
    contractor.setShortName(request.getShortName().toLowerCase());
    contractor.setAddress(request.getAddress());

    return contractor;
  }
}
