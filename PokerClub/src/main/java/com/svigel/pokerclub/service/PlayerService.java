package com.svigel.pokerclub.service;

import com.svigel.pokerclub.model.Player;
import com.svigel.pokerclub.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    public void enterRoom(long playerId, long roomId, String roomName) {
        playerRepository.update(playerId, roomId, roomName);
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }
}
