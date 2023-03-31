package com.svigel.pokerclub.controller;


import com.svigel.pokerclub.service.RoomService;
import com.svigel.pokerclub.web.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    public RoomDTO getRoomInfo(Long id) {
        return RoomDTO.fromRoom(roomService.getRoom(id));
    }

}
