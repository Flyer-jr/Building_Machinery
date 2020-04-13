package com.fly.controller.convertor.equipmentProducer;


import com.fly.controller.requests.equipmentProducer.EquipmentProducerUpdateRequest;
import com.fly.exceptions.EntityNotFoundException;
import com.fly.repository.entities.EquipmentProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

@Component
@RequiredArgsConstructor
public class EquipmentProducerChangeRequestConverter
    extends EquipmentProducerRequestConverter<EquipmentProducerUpdateRequest, EquipmentProducer> {


  @Override
  public EquipmentProducer convert(EquipmentProducerUpdateRequest request) {
    EquipmentProducer equipmentProducer =
        ofNullable(entityManager.find(EquipmentProducer.class, request.getEquipmentProducerId()))
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        EquipmentProducer.class, request.getEquipmentProducerId()));
    return doConvert(equipmentProducer, request);
  }
}
