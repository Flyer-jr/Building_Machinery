package com.fly.controller.requests.constructionSite;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ConstructionSiteUpdateRequest extends ConstructionSiteCreateRequest {

  private Long constructionSiteId;
}
