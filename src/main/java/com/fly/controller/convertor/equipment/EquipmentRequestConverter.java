package com.fly.controller.convertor.equipment;

import com.fly.controller.convertor.EntityConverter;
import com.fly.controller.requests.equipment.ValidEquipmentCreateRequest;
import com.fly.repository.entities.Equipment;


public abstract class EquipmentRequestConverter<S, T> extends EntityConverter<S, T> {

  protected Equipment doConvert(Equipment equipment, ValidEquipmentCreateRequest request) {

    equipment.setStoreNumber(request.getStoreNumber());
    equipment.setModel(request.getModel());
    equipment.setProducer(request.getEquipmentProducer());


    return equipment;
  }
}
