package com.svigel.pokerclub.service;

import com.svigel.pokerclub.model.Player;
import com.svigel.pokerclub.model.Race;
import com.svigel.pokerclub.repository.PlayerRepository;
import com.svigel.pokerclub.repository.RaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final RaceRepository raceRepository;

    public PlayerService(PlayerRepository playerRepository, RaceRepository raceRepository) {
        this.playerRepository = playerRepository;
        this.raceRepository = raceRepository;

        prepareRace();
    }

    private void prepareRace() {
        for (Race.Name name: Race.Name.values()) {
            if (raceRepository.countByName(name) == 0) {
                Race race  = new Race();
                race.setName(name);
                raceRepository.save(race);
            }
        }
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Player findByName(String name) {
        return playerRepository.findByName(name);
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }
}
