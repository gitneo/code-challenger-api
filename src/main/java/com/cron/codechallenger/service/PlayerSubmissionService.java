package com.cron.codechallenger.service;

import com.cron.codechallenger.model.PlayerSubmission;
import com.cron.codechallenger.data.repositories.PlayerSubmissionRepository;
import com.cron.codechallenger.model.Code;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
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

    public String getChallengerResult(Code script) throws UnirestException {
        System.out.println(script.getScript());
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("https://api.jdoodle.com/v1/execute")
        .header("Content-Type", "application/json")
                .body("{\r\n    \"clientId\": \"fb3d6405edf2635e199c4098d0f209ba\"," +
                        "\r\n    \"clientSecret\": \"ff49de19164827d7c754eb0dbd6fa70a85765c7bc2f344352333bef8e99a0e87\"," +
                        "\r\n    \"script\": \""+script.getScript()+"\"," +
                        "\r\n    \"language\": \"java\"," +
                        "\r\n    \"versionIndex\": \"0\"\r\n}")
        .asString();

        return response.getBody();
    }
}
