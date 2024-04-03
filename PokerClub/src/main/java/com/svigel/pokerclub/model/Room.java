package com.svigel.pokerclub.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Entity
@RequiredArgsConstructor
public class Room {
    public Room(String name, Integer minimumBid, List<Player> players) {
        this.name = name;
        this.players = players;
        this.small_bid = minimumBid;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private long small_bid;

    @NotEmpty
    @ManyToMany
    private List<Player> players;

    private long step_sync;

    private long bank;


    private long blind_position;


}
