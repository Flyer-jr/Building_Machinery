package com.fly.controller.convertor.equipment;

import com.fly.controller.requests.equipment.EquipmentUpdateRequest;
import com.fly.exceptions.EntityNotFoundException;
import com.fly.repository.entities.Equipment;
import com.fly.service.equipment.EquipmentValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

@Component
@RequiredArgsConstructor
public class EquipmentChangeRequestConverter
    extends EquipmentRequestConverter<EquipmentUpdateRequest, Equipment> {

  private final EquipmentValidationService service;

  @Override
  public Equipment convert(EquipmentUpdateRequest request) {

    Equipment equipment =
        ofNullable(entityManager.find(Equipment.class, request.getEquipmentId()))
            .orElseThrow(
                () -> new EntityNotFoundException(Equipment.class, request.getEquipmentId()));

    return doConvert(equipment, service.createValid(service.makeCreateRequest(request)));
  }
}
