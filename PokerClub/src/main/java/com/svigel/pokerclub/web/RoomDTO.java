package com.svigel.pokerclub.web;

import com.svigel.pokerclub.model.Player;
import com.svigel.pokerclub.model.Room;

import java.util.List;

public class RoomDTO {
    private String name;
    private Integer smallBid;
    private List<Player> players;
    public static RoomDTO fromRoom(Room room) {
        return null;
    }
    public Room toRoom() {
        return new Room(name, smallBid, players);
    }
}
