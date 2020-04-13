package com.fly.controller.convertor.equipmentProducer;


import com.fly.controller.requests.equipmentProducer.EquipmentProducerCreateRequest;
import com.fly.repository.entities.EquipmentProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EquipmentProducerCreateRequestConverter
    extends EquipmentProducerRequestConverter<EquipmentProducerCreateRequest, EquipmentProducer> {

  public EquipmentProducer convert(EquipmentProducerCreateRequest request) {
    EquipmentProducer equipmentProducer = new EquipmentProducer();

    return doConvert(equipmentProducer, request);
  }
}
