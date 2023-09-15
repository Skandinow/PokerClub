package com.svigel.pokerclub.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.List;


@Entity
public class Player {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Getter
    private String name;

    @Getter
    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    private Race race;

    @Getter
    @Nullable
    private Integer balance;
    @Getter
    @Nullable
    private Integer bid;
    @Nullable
    private Integer win;
    @Nullable
    private Integer chairPlace;


    @Getter
    @ManyToMany
    private List<Room> games;
    @CreationTimestamp
    private Date creationTime;

    public void setRace(Race race) {
        this.race = race;
    }

    @Nullable
    public Integer getWin() {
        return win;
    }

    @Nullable
    public Integer getChairPlace() {
        return chairPlace;
    }


}
