package com.fly.controller.convertor.constructionSite;

import com.fly.controller.requests.constructionSite.ConstructionSiteCreateRequest;
import com.fly.controller.requests.constructionSite.ValidConstructionSiteCreateRequest;
import com.fly.repository.entities.ConstructionSite;
import com.fly.service.constructionSite.ConstructionSiteValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConstructionSiteCreateRequestConverter
    extends ConstructionSiteRequestConverter<ConstructionSiteCreateRequest, ConstructionSite> {

  private final ConstructionSiteValidationService service;

  public ConstructionSite convert(ConstructionSiteCreateRequest request) {
    ConstructionSite constructionSite = new ConstructionSite();

    ValidConstructionSiteCreateRequest validRequest = service.createValid(request);

    return doConvert(constructionSite, validRequest);
  }
}
