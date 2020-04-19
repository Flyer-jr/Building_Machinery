package com.fly.service.order;

import com.fly.controller.requests.order.OrderCreateRequest;
import com.fly.controller.requests.order.OrderUpdateRequest;
import com.fly.controller.requests.order.ValidOrderCreateRequest;
import com.fly.exceptions.EntityNotFoundException;
import com.fly.repository.dao.ConstructionSiteRepository;
import com.fly.repository.dao.EquipmentRepository;
import com.fly.repository.dao.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class OrderValidationService {

  private final UserRepository userRepository;
  private final ConstructionSiteRepository siteRepository;
  private final EquipmentRepository equipmentRepository;

  @Transactional(rollbackFor = Exception.class)
  public ValidOrderCreateRequest createValid(OrderCreateRequest request) {

    ValidOrderCreateRequest validRequest = new ValidOrderCreateRequest();

    try {
      validRequest.setUser(
              userRepository.findUserBySecondName(request.getUserName().toLowerCase()));
    } catch (Exception e) {
      throw new EntityNotFoundException(
              String.format("No User found with name '%s'.", request.getUserName()));
    }
    try {
      validRequest.setConstructionSite(
              siteRepository.findSiteByShortName(request.getConstructionSiteShortName().toLowerCase()));
    } catch (Exception e) {
      throw new EntityNotFoundException(
              String.format(
                      "No Construction Site found with name '%s'.",
                      request.getConstructionSiteShortName()));
    }
    try {
      validRequest.setEquipment(
              new HashSet<>(equipmentRepository.findAllById(request.getEquipment())));
    } catch (Exception e) {
      throw new EntityNotFoundException(String.format("Some of Equipment not found with name "));
    }
    return validRequest;
  }

  public OrderCreateRequest makeCreateRequest(OrderUpdateRequest request) {

    OrderCreateRequest createRequest = new OrderCreateRequest();

    BeanUtils.copyProperties(request, createRequest, "OrderId");

    return createRequest;
  }
}
