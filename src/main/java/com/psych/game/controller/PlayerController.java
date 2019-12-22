package com.psych.game.controller;

import com.psych.game.exception.ResourceNotFoundException;
import com.psych.game.model.Player;
import com.psych.game.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping(path = "/players/create}")
    public Player createPlayer(@Valid @RequestBody Player player){
        return playerRepository.save(player);
    }

}
