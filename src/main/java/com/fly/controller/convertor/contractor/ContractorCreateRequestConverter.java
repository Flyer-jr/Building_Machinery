package com.fly.controller.convertor.contractor;

import com.fly.controller.requests.contractor.ContractorCreateRequest;
import com.fly.repository.entities.Contractor;
import org.springframework.stereotype.Component;

@Component
public class ContractorCreateRequestConverter
    extends ContractorRequestConverter<ContractorCreateRequest, Contractor> {

  @Override
  public Contractor convert(ContractorCreateRequest request) {
    Contractor contractor = new Contractor();
    return doConvert(contractor, request);
  }
}
