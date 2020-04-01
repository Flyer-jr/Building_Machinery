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
  @Size(min = 3, max = 20)
  private String firstName;

  @Pattern(regexp = "\\w+")
  private String secondName;

  @NotNull
  @NotEmpty
  @Pattern(regexp = "^[+]\\d{12}$")
  private String phoneNumber;

  @NotNull
  @NotEmpty
  @Size(min = 6, max = 20)
  private String password;

  @NotNull
  @NotEmpty
  @Pattern(regexp = "\\w+")
  private String post;
}
