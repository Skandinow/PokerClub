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
    private Race race;
    @Getter
    private Integer balance;
    @Getter
    private Integer bid;
    @Nullable
    private Integer win;

    @Getter
    @ManyToMany
    private List<Room> games;
    @Nullable
    private Integer chairPlace;
    @CreationTimestamp
    private Date creationTime;

    @Nullable
    public Integer getWin() {
        return win;
    }

    @Nullable
    public Integer getChairPlace() {
        return chairPlace;
    }


}
