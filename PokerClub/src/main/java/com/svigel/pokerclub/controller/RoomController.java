package com.svigel.pokerclub.controller;


import com.svigel.pokerclub.model.Player;
import com.svigel.pokerclub.model.Room;
import com.svigel.pokerclub.service.RoomService;
import com.svigel.pokerclub.web.PlayerDTO;
import com.svigel.pokerclub.web.RoomCreationRequest;
import com.svigel.pokerclub.web.RoomDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/1")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;
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

    //после этого нужно создать комнату с данным id
    @PostMapping("room/create")
    public Room createRoom(@RequestBody RoomCreationRequest request) {
//        System.out.println(request.getName() + " " + request.getMinimumBid());
//        for(PlayerDTO player : request.getCharacters()) {
//            System.out.println(player.getId() + " " + player.getName() + " " + player.getRace())    ;
//        }
        return roomService.createRoom(request);
    }

    @GetMapping("room/name")
    public Room findRoomByName(String name) {
        return roomService.findRoomByName(name);
    }
}

