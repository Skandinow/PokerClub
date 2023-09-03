package com.svigel.pokerclub.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String room_name;

    private Integer max_number_of_players;

    private long step_sync;

    private long bank;

    private long small_bid;

    private long blind_position;

    @ManyToMany
    private List<Player> players;


}
