package com.cron.codechallenger.service;

import com.cron.codechallenger.model.Player;
import com.cron.codechallenger.data.projections.PlayerRanking;
import com.cron.codechallenger.data.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void createPlayer(Player player){
        playerRepository.save(player);
    }

    public Player getPlayer(long playerId){
        return playerRepository.findById(playerId).get();
    }

    public List<Player> getPlayers(){
        List<Player> listOfPlayers = new ArrayList<>();
        Iterable<Player> list = this.playerRepository.findAll();
        list.forEach(listOfPlayers::add);

        return listOfPlayers;
    }

    public List<PlayerRanking> getChallengeRanking(){
        return this.playerRepository.findTopRankingPlayers();
    }

    public Player playerLogin(String nickname){
        return this.playerRepository.findByNickname(nickname).get();
    }


}
