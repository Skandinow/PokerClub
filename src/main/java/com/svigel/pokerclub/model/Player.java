package com.svigel.pokerclub.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.lang.Nullable;


@Entity
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @Nullable
    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;
    private Integer passive_balance;
    private Integer active_balance;
    private Integer bank_bid;
    private Integer current_bid;
    @Nullable
    private Integer win;
    @Nullable
    private Integer chairPlace;

}
