package com.svigel.pokerclub.repository;

import com.svigel.pokerclub.model.Player;
import com.svigel.pokerclub.model.PokerUser;
import com.svigel.pokerclub.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PlayerRepository extends JpaRepository<Player, Long > {


    Player findByNameAndRace(String name, Race race);

    Player findByNameAndRaceAndUser(String name, Race race, PokerUser user);

    List<Player> findByUser(PokerUser user);
}

