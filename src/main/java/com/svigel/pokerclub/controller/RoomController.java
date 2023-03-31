package com.svigel.pokerclub.controller;


import com.svigel.pokerclub.service.RoomService;
import com.svigel.pokerclub.web.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/room/{id}")
    public RoomDTO getRoomInfo(@PathVariable Long id) {
        return RoomDTO.fromRoom(roomService.getRoom(id));
    }

}
