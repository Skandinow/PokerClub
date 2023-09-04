package com.svigel.pokerclub.controller;

import com.svigel.pokerclub.exception.ValidationException;
import com.svigel.pokerclub.model.PokerUser;
import com.svigel.pokerclub.service.JWTService;
import com.svigel.pokerclub.service.PokerUserService;
import com.svigel.pokerclub.validator.PokerUserRegisterValidator;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/1")
@RestController
public class PokerUserController {
    private final PokerUserService pokerUserService;
    private final JWTService jwtService;
    private final PokerUserRegisterValidator pokerUserRegisterValidator;

    public PokerUserController(PokerUserService service, JWTService jwtService, PokerUserRegisterValidator pokerUserRegisterValidator) {
        this.pokerUserService = service;
        this.jwtService = jwtService;
        this.pokerUserRegisterValidator = pokerUserRegisterValidator;
    }

    @InitBinder("pokerUserRegisterValidator")
    public void PokerUserRegisterBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(pokerUserRegisterValidator);
    }

    @GetMapping("users")
    public List<PokerUser> getAllUsers() {
        return pokerUserService.findAll();
    }

    @GetMapping("users/auth")
    public PokerUser findUserByJwt(@RequestParam String jwt) {
            return jwtService.find(jwt);
    }

    @PostMapping("user/register")
    public PokerUser savePokerUser(@RequestBody @Valid PokerUser pokerUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }

        return pokerUserService.savePokerUser(pokerUser);
    }
}
