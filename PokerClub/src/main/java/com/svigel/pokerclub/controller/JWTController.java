package com.svigel.pokerclub.controller;

import com.svigel.pokerclub.exception.ValidationException;
import com.svigel.pokerclub.model.PokerUser;
import com.svigel.pokerclub.service.JWTService;
import com.svigel.pokerclub.service.PokerUserService;
import com.svigel.pokerclub.validator.PokerUserEnterValidator;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("api/1")
public class JWTController {
    private final JWTService jwtService;
    private final PokerUserEnterValidator validator;
    private final PokerUserService pokerUserService;

    public JWTController(JWTService jwtService, PokerUserEnterValidator validator, PokerUserService service) {
        this.jwtService = jwtService;
        this.validator = validator;
        this.pokerUserService = service;
    }

    @InitBinder("pokerUser")
    public void PokerUserEnterBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(validator);
    }


    @PostMapping("jwt")
    public String create(@RequestBody @Valid PokerUser pokerUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }
        PokerUser user = pokerUserService.findByUsernameAndPassword(pokerUser.getUsername(), pokerUser.getPassword());
        return jwtService.create(user);
    }

}
