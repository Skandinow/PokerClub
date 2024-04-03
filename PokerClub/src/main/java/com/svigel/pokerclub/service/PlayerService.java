package com.svigel.pokerclub.service;

import com.svigel.pokerclub.model.Player;
import com.svigel.pokerclub.model.PokerUser;
import com.svigel.pokerclub.model.Race;
import com.svigel.pokerclub.repository.PlayerRepository;
import com.svigel.pokerclub.repository.PokerUserRepository;
import com.svigel.pokerclub.web.PlayerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    private final PokerUserRepository pokerUserRepository;

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player findByNameAndRace(String name, Race race) {
        return playerRepository.findByNameAndRace(name, race);
    }

    public Player findByNameAndRaceAndUser(String name, Race race, PokerUser user) {
        return playerRepository.findByNameAndRaceAndUser(name, race, user);
    }

    public List<Player> findByPokerUserId(Long id) {
        return playerRepository.findByUser(pokerUserRepository.findById(id).orElse(null));
    }

    public Player findById(PlayerDTO playerDTO) {
        return playerRepository.findById(playerDTO.getId()).get();
    }
}
