package com.fly.controller.requests.order;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateRequest {

  @NotNull
  @NotEmpty
  @Size(min = 3, max = 50)
  private String userName;

  @NotNull
  @NotEmpty
  @Size(min = 3, max = 50)
  private String constructionSiteShortName;

  @NotEmpty
  @NotNull
  private Set<Long> equipment;
}
