package com.svigel.pokerclub.service;

import com.svigel.pokerclub.model.Player;
import com.svigel.pokerclub.model.Room;
import com.svigel.pokerclub.repository.RoomRepository;
import com.svigel.pokerclub.web.RoomCreationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final PlayerService playerService;

    public Room getRoom(Long roomId) {
        return roomRepository.findById(roomId).orElseThrow();
    }

    public Room createRoom(RoomCreationRequest request) {
        List<Player> players = request.getCharacters().stream().map((playerService::findById)).toList();
        return roomRepository.save(new Room(request.getName(), request.getMinimumBid(), players));
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room findRoomByName(String name) {
        return roomRepository.findByName(name);
    }
}
