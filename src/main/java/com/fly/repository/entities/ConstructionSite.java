package com.fly.repository.entities;


import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.sql.Date;
import java.util.Objects;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class ConstructionSite {
    private Long id;
    private String fullName;
    private String shortName;
    private Long customerId;
    private Long responsibleId;
    private Long contractorId;
    private Date dateOfStart;
    private Date dateOfFinish;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
