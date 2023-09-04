package com.svigel.pokerclub.controller;

import com.svigel.pokerclub.model.Player;
import com.svigel.pokerclub.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("players")
    public List<Player> findAll() {
        return playerService.findAll();
    }



//    @PostMapping("/register")
//    public Player register(String name, Integer passive) {
//        return playerService.register(name, passive);
//    }

}
