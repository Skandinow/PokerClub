package com.svigel.pokerclub.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Name name;


    public enum Name {
        HUMAN, ORC, ELF, HALFLING, DWARF, OGRE, DRACONID, CENTAUR

    }
}
