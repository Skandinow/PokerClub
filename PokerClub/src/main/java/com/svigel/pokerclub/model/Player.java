package com.svigel.pokerclub.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Value;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "poker_user_id", nullable = false)
    private PokerUser user;

    @NotEmpty
    private String name;

    @NotEmpty
    private Race race;

    @Nullable
    private Integer balance;

    @Nullable
    private Integer bid;
    @Nullable
    private Integer win;

    @Nullable
    @ElementCollection
    @CollectionTable(name = "player_places_to_sit", joinColumns = @JoinColumn(name = "player_id"))
    @MapKeyColumn(name = "room_name")
    @Column(name = "place_to_sit")
    private Map<Long, Integer> placesToSit;

    @ManyToMany
    private List<Room> games;

    @CreationTimestamp
    private Date creationTime;


}
