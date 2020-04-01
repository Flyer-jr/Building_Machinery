package com.fly.controller.requests.customer;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CustomerUpdateRequest extends CustomerCreateRequest {
  private Long customerId;
}
