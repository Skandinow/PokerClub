package com.svigel.pokerclub.validator;

import com.svigel.pokerclub.model.PokerUser;
import com.svigel.pokerclub.service.PokerUserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PokerUserRegisterValidator implements Validator {
    private final PokerUserService pokerUserService;

    public PokerUserRegisterValidator(PokerUserService pokerUserService) {
        this.pokerUserService = pokerUserService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PokerUser.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!errors.hasErrors()) {
            PokerUser pokerUser = (PokerUser) target;
            if (pokerUserService.findByUsername(pokerUser.getUsername()) != null) {
                errors.reject("invalid-login", "This username is in use");
            }
        }
    }
}
