package com.svigel.pokerclub.web;

import com.svigel.pokerclub.model.Player;
import com.svigel.pokerclub.model.Room;
import lombok.Getter;

import java.util.List;

@Getter
public class RoomCreationRequest {
    private String name;
    private Integer minimumBid;
    private List<PlayerDTO> characters;
}
