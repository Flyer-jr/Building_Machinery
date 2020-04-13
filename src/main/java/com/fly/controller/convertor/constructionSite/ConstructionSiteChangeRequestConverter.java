package com.fly.controller.convertor.constructionSite;

import com.fly.controller.requests.constructionSite.ConstructionSiteUpdateRequest;
import com.fly.exceptions.EntityNotFoundException;
import com.fly.repository.entities.ConstructionSite;
import com.fly.service.constructionSite.ConstructionSiteValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

@Component
@RequiredArgsConstructor
public class ConstructionSiteChangeRequestConverter
    extends ConstructionSiteRequestConverter<ConstructionSiteUpdateRequest, ConstructionSite> {

  private final ConstructionSiteValidationService service;

  @Override
  public ConstructionSite convert(ConstructionSiteUpdateRequest request) {
    ConstructionSite constructionSite =
        ofNullable(entityManager.find(ConstructionSite.class, request.getConstructionSiteId()))
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        ConstructionSite.class, request.getConstructionSiteId()));
    return doConvert(constructionSite, service.createValid(service.makeCreateRequest(request)));
  }
}
