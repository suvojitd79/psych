package com.psych.game.controller;

import com.psych.game.exception.ExceptionPacket;
import com.psych.game.exception.ResourceNotFoundException;
import com.psych.game.model.Player;
import com.psych.game.repository.PlayerRepository;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping(value = "/api", method = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping(path = "/players")
    public List<Player> getAll(){
        return playerRepository.findAll();
    }

    @GetMapping(path = "/players/{id}")
    public Player getPlayer(@PathVariable(value = "id") Long id){
        return playerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("player","id",id));
    }

    @PostMapping(path = "/players/new")
    public ResponseEntity<Object> createPlayer(@Valid @RequestBody Player player){
        try {
            return new ResponseEntity(playerRepository.save(player), HttpStatus.valueOf(Response.SC_CREATED));
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ExceptionPacket(e.getLocalizedMessage(), Response.SC_BAD_REQUEST), HttpStatus.valueOf(Response.SC_BAD_REQUEST));
        }
    }

}
