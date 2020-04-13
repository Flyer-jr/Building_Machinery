package com.fly.controller.requests.equipment;

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
public class EquipmentCreateRequest {

  @NotNull
  @NotEmpty
  @Size(min = 3, max = 100)
  private String storeNumber;

  @NotNull
  @NotEmpty
  @Size(min = 3, max = 100)
  private String model;

  @NotNull
  @NotEmpty
  private String producerName;
}
