package com.svigel.pokerclub.service;

import com.svigel.pokerclub.model.Room;
import com.svigel.pokerclub.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
