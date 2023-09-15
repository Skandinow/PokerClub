package com.svigel.pokerclub.repository;

import com.svigel.pokerclub.model.Player;
import com.svigel.pokerclub.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RaceRepository extends JpaRepository<Race, Long > {

    int countByName(Race.Name name);
}

