package com.cron.codechallenger.controller;

import com.cron.codechallenger.model.Player;
import com.cron.codechallenger.data.projections.PlayerRanking;
import com.cron.codechallenger.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PlayerController {

    PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/player")
    public void createPlayer(@RequestBody Player player){
        this.playerService.createPlayer(player);
    }

    @GetMapping("/player/submission")
    public List<PlayerRanking> getTopPlayers(){
        return this.playerService.getChallengeRanking();
    }
}
