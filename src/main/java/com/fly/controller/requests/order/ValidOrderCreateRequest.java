package com.fly.controller.requests.order;

import com.fly.repository.entities.ConstructionSite;
import com.fly.repository.entities.Equipment;
import com.fly.repository.entities.User;
import lombok.*;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
public class ValidOrderCreateRequest {

    private User user;


    private ConstructionSite constructionSite;


    private Set<Equipment> equipment;
}

