package com.svigel.pokerclub.controller;


import com.svigel.pokerclub.model.Room;
import com.svigel.pokerclub.service.RoomService;
import com.svigel.pokerclub.web.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/1")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/room/{id}/step")
    public Long getRoomStep(@PathVariable Long id) {
        return roomService.getRoom(id).getStep_sync();
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/room/{id}/full")
    public RoomDTO getRoomInfo(@PathVariable Long id) {
        return RoomDTO.fromRoom(roomService.getRoom(id));
    }

    @PostMapping("/createRoom")
    public Room createRoom() {
        return roomService.createRoom();
    }

}
