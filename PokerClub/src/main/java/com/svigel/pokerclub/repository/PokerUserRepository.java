package com.svigel.pokerclub.repository;

import com.svigel.pokerclub.model.PokerUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokerUserRepository extends JpaRepository<PokerUser, Long> {
    static PokerUser findByUsername(String name) {
        return findByUsername(name);
    }

    // TODO: 8/30/23 сделать нормальный query какого хуя сверху
    PokerUser findByUsernameAndPassword(String login, String password);
}
