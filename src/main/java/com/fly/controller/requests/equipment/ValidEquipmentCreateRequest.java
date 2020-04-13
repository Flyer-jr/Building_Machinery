package com.fly.controller.requests.equipment;

import com.fly.repository.entities.ConstructionSite;
import com.fly.repository.entities.Equipment;
import com.fly.repository.entities.EquipmentProducer;
import com.fly.repository.entities.User;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
public class ValidEquipmentCreateRequest {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String storeNumber;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String model;

    @NotNull
    @NotEmpty
    private EquipmentProducer equipmentProducer;
}

