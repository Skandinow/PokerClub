package com.svigel.pokerclub.repository;

import com.svigel.pokerclub.model.Player;
import com.svigel.pokerclub.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface PlayerRepository extends JpaRepository<Player, Long > {

    Player findByName(String name);

    Player findByNameAndRace(String name, Race race);

    Player findByNameAndRaceAndId(String name, Race race, Long id);
}

