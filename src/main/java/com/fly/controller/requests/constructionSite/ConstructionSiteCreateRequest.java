package com.fly.controller.requests.constructionSite;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ConstructionSiteCreateRequest {

  @NotNull
  @NotEmpty
  @Size(min = 3, max = 200)
  private String fullName;

  @NotNull
  @NotEmpty
  @Size(min = 3, max = 50)
  private String shortName;

  @NotNull
  @NotEmpty
  private String customerShortName;

  @NotNull
  @NotEmpty
  private String userName;

  @NotNull
  @NotEmpty
  private String contractorShortName;

  private Date dateOfStart;

  private Date dateOfFinish;
}
