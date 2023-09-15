package com.svigel.pokerclub.repository;

import com.svigel.pokerclub.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface PlayerRepository extends JpaRepository<Player, Long > {

    Player findByName(String name);
}

