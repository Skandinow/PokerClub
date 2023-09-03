package com.svigel.pokerclub.form.validator;

import com.svigel.pokerclub.form.UserRegisterCredentials;
import com.svigel.pokerclub.service.PokerUserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserCredentialsRegisterValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserCredentialsRegisterValidator.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!errors.hasErrors()) {
            UserRegisterCredentials user = (UserRegisterCredentials) target;
            if (PokerUserService.findByUsername(user.getName()) != null) {
                errors.reject("invalid-login-or-password", "Login is already in use");
            }
        }
    }
}
