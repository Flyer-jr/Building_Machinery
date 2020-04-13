package com.fly.controller.convertor.equipment;

import com.fly.controller.requests.customer.CustomerCreateRequest;
import com.fly.controller.requests.equipment.EquipmentCreateRequest;
import com.fly.controller.requests.equipment.ValidEquipmentCreateRequest;
import com.fly.repository.entities.Customer;
import com.fly.repository.entities.Equipment;
import com.fly.service.equipment.EquipmentValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EquipmentCreateRequestConverter
    extends EquipmentRequestConverter<EquipmentCreateRequest, Equipment> {

  private final EquipmentValidationService service;

  @Override
  public Equipment convert(EquipmentCreateRequest request) {
    Equipment equipment = new Equipment();

    ValidEquipmentCreateRequest validRequest = service.createValid(request);

    return doConvert(equipment, validRequest);
  }
}
