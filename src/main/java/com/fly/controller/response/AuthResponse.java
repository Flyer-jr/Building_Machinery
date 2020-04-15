package com.fly.controller.response;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponse {

  private String login;
  private String authToken;
}
