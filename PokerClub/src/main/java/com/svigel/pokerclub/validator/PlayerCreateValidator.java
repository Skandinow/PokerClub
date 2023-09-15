package com.svigel.pokerclub.validator;

import com.svigel.pokerclub.model.Player;
import com.svigel.pokerclub.service.PlayerService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PlayerCreateValidator implements Validator {
    private final PlayerService playerService;

    public PlayerCreateValidator(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Player.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!errors.hasErrors()) {
            Player player = (Player) target;
            if (playerService.findByNameAndRaceAndId(player.getName(), player.getRace(), player.getId()) != null) {
                errors.reject("invalid-name-and-race", "You can't create two similar players");
            }
        }
    }
}
