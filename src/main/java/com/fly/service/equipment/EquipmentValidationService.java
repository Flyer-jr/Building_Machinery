package com.fly.service.equipment;

import com.fly.controller.requests.equipment.EquipmentCreateRequest;
import com.fly.controller.requests.equipment.EquipmentUpdateRequest;
import com.fly.controller.requests.equipment.ValidEquipmentCreateRequest;
import com.fly.exceptions.EntityNotFoundException;
import com.fly.repository.dao.EquipmentProducerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EquipmentValidationService {

  private final EquipmentProducerRepository producerRepository;

  public ValidEquipmentCreateRequest createValid(EquipmentCreateRequest request) {

    ValidEquipmentCreateRequest validRequest = new ValidEquipmentCreateRequest();
    validRequest.setStoreNumber(request.getStoreNumber());
    validRequest.setModel(request.getModel());
    try {

      validRequest.setEquipmentProducer(
          producerRepository.findEquipmentProducerByName(request.getProducerName()));
    } catch (Exception e) {

      throw new EntityNotFoundException(
          String.format("No equipment producer found with name '%s'.", request.getProducerName()));
    }

    return validRequest;
  }

  public EquipmentCreateRequest makeCreateRequest(EquipmentUpdateRequest request) {

    EquipmentCreateRequest createRequest = new EquipmentCreateRequest();

    BeanUtils.copyProperties(request, createRequest, "equipmentId");

    return createRequest;
  }
}
