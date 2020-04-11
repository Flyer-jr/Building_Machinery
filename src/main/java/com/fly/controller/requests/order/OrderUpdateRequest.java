package com.fly.controller.requests.order;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpdateRequest extends OrderCreateRequest {
  private Long orderId;
}
