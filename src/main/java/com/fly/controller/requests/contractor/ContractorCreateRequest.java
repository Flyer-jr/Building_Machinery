package com.fly.controller.requests.contractor;

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
public class ContractorCreateRequest {

  @NotNull
  @NotEmpty
  @Size(min = 3, max = 100)
  private String fullName;

  @NotNull
  @NotEmpty
  @Size(min = 3, max = 50)
  private String shortName;

  @NotNull
  @NotEmpty
  @Size(min = 3, max = 200)
  private String address;
}
