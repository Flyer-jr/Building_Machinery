package com.fly.repository.entities;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.sql.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode

public class User {

    private Long id;
    private String firstName;
    private String secondName;
    private String phoneNumber;
    private String password;
    private String post;
    private boolean isActual;
    private Date dateOfDismiss;

    @Override
    public String toString () {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }


}
