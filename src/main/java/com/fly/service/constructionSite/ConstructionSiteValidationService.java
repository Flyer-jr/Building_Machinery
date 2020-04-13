package com.fly.service.constructionSite;

import com.fly.controller.requests.constructionSite.ConstructionSiteCreateRequest;
import com.fly.controller.requests.constructionSite.ConstructionSiteUpdateRequest;
import com.fly.controller.requests.constructionSite.ValidConstructionSiteCreateRequest;
import com.fly.exceptions.EntityNotFoundException;
import com.fly.repository.dao.ConstructionSiteRepository;
import com.fly.repository.dao.ContractorRepository;
import com.fly.repository.dao.CustomerRepository;
import com.fly.repository.dao.UserRepository;
import com.fly.repository.entities.ConstructionSite;
import jdk.jfr.Frequency;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.channels.ScatteringByteChannel;

@Service
@RequiredArgsConstructor
public class ConstructionSiteValidationService {

  private final UserRepository userRepository;

  private final ContractorRepository contractorRepository;

  private final CustomerRepository customerRepository;

  public ValidConstructionSiteCreateRequest createValid(ConstructionSiteCreateRequest request) {

    ValidConstructionSiteCreateRequest validRequest = new ValidConstructionSiteCreateRequest();

    try {
      validRequest.setUser(
          userRepository.findUserBySecondName(request.getUserName().toLowerCase()));
    } catch (Exception e) {
      throw new UsernameNotFoundException(
          String.format("No user found with username '%s'.", request.getUserName()));
    }
    try {
      validRequest.setContractor(
          contractorRepository.findContractorByShortName(
              request.getContractorShortName().toLowerCase()));
    } catch (Exception e) {
      throw new EntityNotFoundException(
          String.format("No contractor found with name '%s'.", request.getContractorShortName()));
    }
    try {
      validRequest.setCustomer(
          customerRepository.findCustomerByShortName(request.getCustomerShortName().toLowerCase()));
    } catch (Exception e) {
      throw new EntityNotFoundException(
          String.format("No contractor found with name '%s'.", request.getCustomerShortName()));
    }
    validRequest.setDateOfStart(request.getDateOfStart());
    validRequest.setDateOfFinish(request.getDateOfFinish());
    validRequest.setFullName(request.getFullName());
    validRequest.setShortName(request.getShortName().toLowerCase());

    return validRequest;
  }

  public ConstructionSiteCreateRequest makeCreateRequest(ConstructionSiteUpdateRequest request) {

    ConstructionSiteCreateRequest createRequest = new ConstructionSiteCreateRequest();

    BeanUtils.copyProperties(request, createRequest, "constructionSiteId");
    return createRequest;
  }
}
