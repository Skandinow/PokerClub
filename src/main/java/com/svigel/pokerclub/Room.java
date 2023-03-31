package com.svigel.pokerclub;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private long step;
    private long bank;
    private long small_bid;
    private long blind_position;
    private PlayerCondition condition;
    private String cards;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Player> players;

}
