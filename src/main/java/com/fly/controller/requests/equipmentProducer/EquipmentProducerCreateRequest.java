package com.fly.controller.requests.equipmentProducer;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentProducerCreateRequest {

  @NotNull
  @NotEmpty
  @Size(min = 3, max = 100)
  private String name;

  @NotNull
  @NotEmpty
  @Size(min = 3, max = 200)
  private String postAddress;
}
