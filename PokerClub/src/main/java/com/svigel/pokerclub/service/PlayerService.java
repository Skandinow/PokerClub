package com.svigel.pokerclub.service;

import com.svigel.pokerclub.model.Player;
import com.svigel.pokerclub.model.Race;
import com.svigel.pokerclub.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    public List<Player> findAll() {
        return playerRepository.findAll();
    }

//    public Player findByName(String name) {
//        return playerRepository.findByName(name);
//    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player findByNameAndRace(String name, Race race) {
        return playerRepository.findByNameAndRace(name, race);
    }

    public Player findByNameAndRaceAndId(String name, Race race, Long id) {
        return playerRepository.findByNameAndRaceAndId(name, race, id);
    }
}
