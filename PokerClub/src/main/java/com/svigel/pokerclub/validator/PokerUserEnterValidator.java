package com.svigel.pokerclub.validator;

import com.svigel.pokerclub.model.PokerUser;
import com.svigel.pokerclub.service.PokerUserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PokerUserEnterValidator implements Validator {
    private final PokerUserService pokerUserService;

    public PokerUserEnterValidator(PokerUserService pokerUserService) {
        this.pokerUserService = pokerUserService;
    }

    @Override
    public boolean supports(@NotNull Class<?> clazz) {
        return PokerUser.class.equals(clazz);
    }

    @Override
    public void validate(@NotNull Object target, Errors errors) {
        if (!errors.hasErrors()) {
            PokerUser pokerUser = (PokerUser) target;
            if (pokerUserService.findByUsernameAndPassword(pokerUser.getUsername(), pokerUser.getPassword()) == null) {
                errors.reject("invalid-login-or-password", "Invalid login or password");
            }
        }
     }
}
