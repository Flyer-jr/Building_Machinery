package com.fly.controller.requests.user;



import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {

    @NotEmpty(message = "First name is required")
    @NotNull(message = "First name is required")
    private String firstName;

    @NotEmpty(message = "Second name is required")
    @NotNull(message = "Second name is required")
    private String secondName;

    @NotEmpty(message = "Phone number is required")
    @NotNull(message = "Phone number is required")
    @Pattern(regexp = "^[+]\\d{12}$", message = "+375XXxxxxxxx format")
    private String phoneNumber;

    @NotEmpty(message = "Login is required")
    @NotNull(message = "Login is required")
    @Size(min = 3, max = 20, message = "Login is too short or too long")
    private String login;

    @NotEmpty(message = "Password is required")
    @NotNull(message = "Password is required")
    @Size(min = 3, max = 20, message = "Password is too short or too long")
    private String password;

    @NotEmpty(message = "email is required")
    @NotNull(message = "email is required")
    @Email(message = "wrong email format")
    private String email;

    @NotEmpty(message = "post is required")
    @NotNull(message = "post is required")
    private String post;
}
