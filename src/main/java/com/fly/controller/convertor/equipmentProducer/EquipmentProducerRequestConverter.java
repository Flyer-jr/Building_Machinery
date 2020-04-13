package com.fly.controller.convertor.equipmentProducer;

import com.fly.controller.convertor.EntityConverter;
import com.fly.controller.requests.equipmentProducer.EquipmentProducerCreateRequest;
import com.fly.repository.entities.EquipmentProducer;

public abstract class EquipmentProducerRequestConverter<S, T> extends EntityConverter<S, T> {

  protected EquipmentProducer doConvert(
      EquipmentProducer equipmentProducer, EquipmentProducerCreateRequest request) {

    equipmentProducer.setName(request.getName());
    equipmentProducer.setPostAddress(request.getPostAddress());
    return equipmentProducer;
  }
}
