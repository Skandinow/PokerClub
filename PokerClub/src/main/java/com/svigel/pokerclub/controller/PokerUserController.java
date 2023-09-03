package com.svigel.pokerclub.controller;

import com.svigel.pokerclub.model.PokerUser;
import com.svigel.pokerclub.service.JWTService;
import com.svigel.pokerclub.service.PokerUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/1")
@RestController
public class PokerUserController {
    private final PokerUserService service;
    private final JWTService jwtService;

    public PokerUserController(PokerUserService service, JWTService jwtService) {
        this.service = service;
        this.jwtService = jwtService;
    }

    @GetMapping("users")
    public List<PokerUser> getAllUsers() {
        System.out.println("meow");
        return service.findAll();
    }

    @GetMapping("users/auth")
    public PokerUser findUserByJwt(@RequestParam String jwt) {
            return jwtService.find(jwt);
    }



}
