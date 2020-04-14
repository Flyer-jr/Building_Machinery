package com.fly.controller.requests.user;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {

  @NotNull
  @NotEmpty
  private String firstName;

  @NotNull
  @NotEmpty
  private String secondName;

  @NotNull
  @NotEmpty
  @Pattern(regexp = "^[+]\\d{12}$")
  private String phoneNumber;

  @NotNull
  @NotEmpty
  @Size(min = 6, max = 20)
  private String login;

  @NotNull
  @NotEmpty
  private String password;

  @NotNull
  @NotEmpty
  private String post;
}
