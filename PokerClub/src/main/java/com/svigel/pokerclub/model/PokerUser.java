package com.svigel.pokerclub.model;


import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Getter
public class PokerUser {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;

    private boolean admin;

    @CreationTimestamp
    private Date creationTime;

    @OneToMany
    private List<Player> players;

    @OneToMany
    private List<Room> rooms;
}
