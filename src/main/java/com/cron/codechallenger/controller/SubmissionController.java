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
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/submission")
    public void createSubmission(@RequestBody PlayerSubmission submission){

        Task task =  taskService.getTask(submission.getTask().getId());
        Player player = playerService.getPlayer(submission.getPlayer().getId());


        submission.setTask(task);
        submission.setPlayer(player);

        this.playerSubmissionService.createSubmission(submission);
    }

    @CrossOrigin
    @GetMapping("/sub/viewSubmission")
    public List<PlayerSubmission> getSubmissions(){
        return this.playerSubmissionService.getAllSubmissions();
    }

    @CrossOrigin
    @PostMapping("/submission/result")
    public String getSubmissionResult(@RequestBody Code script) throws UnirestException {
        return this.playerSubmissionService.getChallengerResult(script);
    }
}
