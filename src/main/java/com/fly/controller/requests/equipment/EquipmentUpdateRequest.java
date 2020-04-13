package com.fly.controller.requests.equipment;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentUpdateRequest extends EquipmentCreateRequest {

  private Long equipmentId;
}
