package com.fly.controller.requests.customer;

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
public class CustomerCreateRequest {

  @NotNull
  @NotEmpty
  @Size(min = 3, max = 100)
  private String companyName;

  @NotNull
  @NotEmpty
  @Size(min = 3, max = 50)
  private String managerName;

  @NotNull
  @NotEmpty
  @Pattern(regexp = "^[+]\\d{12}$")
  private String phoneNumber;

  @NotNull
  @NotEmpty
  @Size(min = 3, max = 200)
  private String address;
}
