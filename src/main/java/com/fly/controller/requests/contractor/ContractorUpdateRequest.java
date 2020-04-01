package com.fly.controller.requests.contractor;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ContractorUpdateRequest extends ContractorCreateRequest {
  private Long contractorId;
}
