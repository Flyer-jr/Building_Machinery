package com.fly.controller.convertor.constructionSite;

import com.fly.controller.convertor.EntityConverter;
import com.fly.controller.requests.constructionSite.ValidConstructionSiteCreateRequest;
import com.fly.controller.requests.contractor.ContractorCreateRequest;
import com.fly.repository.entities.ConstructionSite;
import com.fly.repository.entities.Contractor;

public abstract class ConstructionSiteRequestConverter<S, T> extends EntityConverter<S, T> {

  protected ConstructionSite doConvert(
      ConstructionSite constructionSite, ValidConstructionSiteCreateRequest request) {

    constructionSite.setFullName(request.getFullName());
    constructionSite.setShortName(request.getShortName().toLowerCase());
    constructionSite.setContractor(request.getContractor());
    constructionSite.setResponsible(request.getUser());
    constructionSite.setCustomer(request.getCustomer());
    return constructionSite;
  }
}
