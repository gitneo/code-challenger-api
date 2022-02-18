package com.cron.codechallenger.controller;

import com.cron.codechallenger.model.Player;
import com.cron.codechallenger.model.PlayerSubmission;
import com.cron.codechallenger.model.Code;
import com.cron.codechallenger.model.Task;
import com.cron.codechallenger.service.PlayerService;
import com.cron.codechallenger.service.PlayerSubmissionService;
import com.cron.codechallenger.service.TaskService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SubmissionController {

    PlayerSubmissionService playerSubmissionService;
    PlayerService playerService;
    TaskService taskService;

    @Autowired
    public SubmissionController(PlayerSubmissionService playerSubmissionService, PlayerService playerService, TaskService taskService) {
        this.playerSubmissionService = playerSubmissionService;
        this.playerService = playerService;
        this.taskService = taskService;
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/submission")
    public ResponseEntity createSubmission(@RequestBody PlayerSubmission submission){

        if(submission != null){
            Task task =  taskService.getTask(submission.getTask().getId());
            Player player = playerService.getPlayer(submission.getPlayer().getId());
            submission.setTask(task);
            submission.setPlayer(player);
        }


        try{
            this.playerSubmissionService.createSubmission(submission);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(HttpStatus.OK);
    }


    @CrossOrigin
    @PostMapping("/submission/result")
    public ResponseEntity getSubmissionResult(@RequestBody Code script) {
        String result = "";
        try{
            result = this.playerSubmissionService.getChallengerResult(script);
        }catch(UnirestException e){
            return new ResponseEntity(HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity(result,null,HttpStatus.OK);
    }
}
