package com.svigel.pokerclub.form;

import com.svigel.pokerclub.model.Race;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CharacterCreateCredentials {
    @NotBlank
    @Size(min = 2, max = 12)
    @Pattern(regexp = "[a-zA-Zа-яА-Я]{2,12}", message = "Expected Latin or Cyrillic letters")
    private String name;

    private Race race;

}
