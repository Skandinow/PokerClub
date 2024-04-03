package com.svigel.pokerclub.controller;

import com.svigel.pokerclub.exception.ValidationException;
import com.svigel.pokerclub.model.Player;
import com.svigel.pokerclub.model.Race;
import com.svigel.pokerclub.service.PlayerService;
import com.svigel.pokerclub.validator.PlayerCreateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/1")
public class PlayerController {
    private final PlayerService playerService;
    private final PlayerCreateValidator playerCreateValidator;

    @InitBinder("player")
    public void PlayerBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(playerCreateValidator);
    }

    @Autowired
    PlayerController(PlayerService playerService, PlayerCreateValidator playerCreateValidator) {
        this.playerService = playerService;
        this.playerCreateValidator = playerCreateValidator;

    }

    @GetMapping("players")
    public List<Player> findAll() {
        return playerService.findAll();
    }

    @GetMapping("players/{id}")
    public List<Player> findByPokerUserId(@PathVariable Long id) {
        return playerService.findByPokerUserId(id);
    }



    @PostMapping("/player/save")
    public Player savePlayer(@RequestBody @Valid Player player, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }

        return playerService.savePlayer(player);
    }

    @GetMapping("/races")
    public List<Race> getRaces() {
        return List.of(Race.values());
    }

}
