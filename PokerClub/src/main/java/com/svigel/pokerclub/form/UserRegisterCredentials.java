package com.svigel.pokerclub.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class UserRegisterCredentials {
    @NotBlank
    @NotNull
    @Size(min=1, max=255)
    @Pattern(regexp = "[a-zA-Z]{2,16}", message = "Expected Latin letters")
    private String name;

    @NotEmpty
    @Size(min = 2, max = 24)
    @Pattern(regexp = "[a-zA-Z]{2,24}", message = "Expected Latin letters")
    private String login;

    @NotEmpty
    @Size(min = 1, max = 60)
    private String password;

}
