package com.svigel.pokerclub.controller;

import com.svigel.pokerclub.service.PokerUserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokerUserController {
    private final PokerUserService service;

    public PokerUserController(PokerUserService service) {
        this.service = service;
    }


}
