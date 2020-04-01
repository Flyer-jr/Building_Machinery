package com.fly.controller.requests.user;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest extends UserCreateRequest {
  private Long userId;
}
