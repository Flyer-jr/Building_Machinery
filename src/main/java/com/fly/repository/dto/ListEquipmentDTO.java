package com.fly.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ListEquipmentDTO {
  private Long id;
  private String storeNumber;
  private String value;
}