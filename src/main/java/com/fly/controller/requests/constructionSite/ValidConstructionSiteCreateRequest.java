package com.fly.controller.requests.constructionSite;

import com.fly.repository.entities.*;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
public class ValidConstructionSiteCreateRequest {

    private String fullName;

    private String shortName;

    private Customer customer;

    private User user;

    private Contractor contractor;

    private Date dateOfStart;

    private Date dateOfFinish;
}

