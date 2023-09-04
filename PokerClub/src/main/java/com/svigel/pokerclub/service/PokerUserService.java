package com.svigel.pokerclub.service;

import com.svigel.pokerclub.model.PokerUser;
import com.svigel.pokerclub.repository.PokerUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokerUserService {
    private final PokerUserRepository pokerUserRepository;

    public PokerUserService(PokerUserRepository pokerUserRepository) {
        this.pokerUserRepository = pokerUserRepository;
    }

    public PokerUser findByUsernameAndPassword(String username, String password) {
        return pokerUserRepository.findByUsernameAndPassword(username, password);
    }

    public PokerUser findByUsername(String name) {
        return pokerUserRepository.findByUsername(name);
    }

    public List<PokerUser> findAll() {
        return pokerUserRepository.findAll();
    }

    public PokerUser findById(Long id) {
        return id == null ? null : pokerUserRepository.findById(id).orElse(null);

    }

    public PokerUser savePokerUser(PokerUser user) {
        return pokerUserRepository.save(user);
    }
}
