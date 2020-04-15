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
    @ApiModelProperty(required = true, dataType = "string", notes = "user login")
    private String login;

    @NotEmpty
    @ApiModelProperty(required = true, dataType = "string", notes = "user password")
    private String password;
}
