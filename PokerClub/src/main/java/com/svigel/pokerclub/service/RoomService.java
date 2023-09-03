package com.svigel.pokerclub.service;

import com.svigel.pokerclub.model.Room;
import com.svigel.pokerclub.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository repository;

    @Autowired
    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    public Room getRoom(Long roomId) {
        return repository.findById(roomId).orElseThrow();
    }

    public Room createRoom() {
        Room room = new Room();
        return repository.save(room);
    }

    public List<Room> getAllRooms() {
        return repository.findAll();
    }

//    public void enterRoom(Player player, Room room) {
//        repository.addPlayer(player.getId(), room.getId());
//    }
}
