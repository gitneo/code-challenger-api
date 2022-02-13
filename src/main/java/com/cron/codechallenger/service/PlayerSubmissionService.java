package com.cron.codechallenger.service;

import com.cron.codechallenger.model.PlayerSubmission;
import com.cron.codechallenger.data.repositories.PlayerSubmissionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerSubmissionService {

    PlayerSubmissionRepository playerSubmissionRepository;

    public PlayerSubmissionService(PlayerSubmissionRepository playerSubmissionRepository) {
        this.playerSubmissionRepository = playerSubmissionRepository;
    }

    public void createSubmission(PlayerSubmission playerSubmission){
        this.playerSubmissionRepository.save(playerSubmission);
    }
    public List<PlayerSubmission> getAllSubmissions(){
        List<PlayerSubmission> listOfSubmissions =  new ArrayList<>();
        this.playerSubmissionRepository.findAll().forEach(listOfSubmissions::add);
        return listOfSubmissions;
    }
}
