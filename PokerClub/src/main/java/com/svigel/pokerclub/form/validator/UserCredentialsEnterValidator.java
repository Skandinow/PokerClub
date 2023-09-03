//package com.svigel.pokerclub.form.validator;
//
//import com.svigel.pokerclub.form.UserEnterCredentials;
//import com.svigel.pokerclub.service.PokerUserService;
//import org.springframework.stereotype.Component;
//
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
//@Component
//public class UserCredentialsEnterValidator implements Validator {
//    private final PokerUserService userService;
//
//    public UserCredentialsEnterValidator(PokerUserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return UserEnterCredentials.class.equals(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        if (!errors.hasErrors()) {
//            UserEnterCredentials enterForm = (UserEnterCredentials) target;
//            if (userService.findByUsernameAndPassword(enterForm.getLogin(), enterForm.getPassword()) == null) {
//                errors.reject("invalid-login-or-password", "Invalid login or password");
//            }
//        }
//    }
//}
