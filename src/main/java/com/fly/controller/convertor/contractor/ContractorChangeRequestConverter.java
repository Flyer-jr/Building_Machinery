package com.fly.controller.convertor.contractor;

import com.fly.controller.requests.contractor.ContractorUpdateRequest;
import com.fly.exceptions.EntityNotFoundException;
import com.fly.repository.entities.Contractor;
import com.fly.repository.entities.User;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

@Component
public class ContractorChangeRequestConverter
    extends ContractorRequestConverter<ContractorUpdateRequest, Contractor> {

  @Override
  public Contractor convert(ContractorUpdateRequest request) {
    Contractor contractor =
        ofNullable(entityManager.find(Contractor.class, request.getContractorId()))
            .orElseThrow(() -> new EntityNotFoundException(User.class, request.getContractorId()));
    return doConvert(contractor, request);
  }
}
