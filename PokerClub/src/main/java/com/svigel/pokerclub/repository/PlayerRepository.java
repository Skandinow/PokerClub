package com.svigel.pokerclub.repository;

import com.svigel.pokerclub.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface PlayerRepository extends JpaRepository<Player, Long > {
    @Modifying
    @Query(value = "UPDATE public.player SET room_id=?2 where id=?1", nativeQuery = true)
    void update(long playerId, long roomId, String roomName);
}
