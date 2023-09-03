package com.svigel.pokerclub.service;

import com.svigel.pokerclub.model.PokerUser;
import com.svigel.pokerclub.repository.PokerUserRepository;
import org.springframework.stereotype.Service;

@Service
public class PokerUserService {
    private final PokerUserRepository pokerUserRepository;

    public PokerUserService(PokerUserRepository pokerUserRepository) {
        this.pokerUserRepository = pokerUserRepository;
    }

    public static PokerUser findByUsername(String name) {
        return PokerUserRepository.findByUsername(name);
    }

    public PokerUser findByUsernameAndPassword(String login, String password) {
        return pokerUserRepository.findByUsernameAndPassword(login, password);
    }
}
