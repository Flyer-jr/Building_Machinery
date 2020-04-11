package com.fly.controller.requests.authentication;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor

@ApiModel(description = "Object for user authentication")
public class AuthenticationRequest implements Serializable {

    @NotEmpty
    @ApiModelProperty(required = true, allowableValues = "+375293047729", dataType = "string", notes = "user phone number for login")
    private String phoneNumber;

    @NotEmpty
    @ApiModelProperty(required = true, allowableValues = "+375293047729", dataType = "string", notes = "user password for login")
    private String password;
}
