package com.cron.codechallenger.controller;

import com.cron.codechallenger.authrntication.PlayerDetails;
import com.cron.codechallenger.model.Player;
import com.cron.codechallenger.data.projections.PlayerRanking;
import com.cron.codechallenger.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PlayerController {

    PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @CrossOrigin
    @PostMapping("/player")
    public void createPlayer(@RequestBody Player player){
        this.playerService.createPlayer(player);
    }

    @CrossOrigin
    @GetMapping("/player/submission")
    public List<PlayerRanking> getTopPlayers(){
        return this.playerService.getChallengeRanking();
    }

    @CrossOrigin
    @GetMapping("/login")
    public Map loginPlayer(@AuthenticationPrincipal PlayerDetails player){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("nickname", player.getUsername());
        map.put("id",player.getId());
        return map;
    }
}
