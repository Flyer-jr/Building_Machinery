package com.fly.controller.requests.equipmentProducer;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentProducerUpdateRequest extends EquipmentProducerCreateRequest {

  private Long equipmentProducerId;
}
