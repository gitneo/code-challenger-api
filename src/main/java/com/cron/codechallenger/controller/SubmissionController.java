package com.cron.codechallenger.controller;

import com.cron.codechallenger.model.Player;
import com.cron.codechallenger.model.PlayerSubmission;
import com.cron.codechallenger.model.Task;
import com.cron.codechallenger.service.PlayerService;
import com.cron.codechallenger.service.PlayerSubmissionService;
import com.cron.codechallenger.service.TaskService;
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


    @PostMapping("/submission")
    public void createSubmission(@RequestBody PlayerSubmission submission){

        Task task =  taskService.getTask(submission.getTask().getId());
        Player player = playerService.getPlayer(submission.getPlayer().getId());
        //write code to compile code and get result
        submission.setTask(task);
        submission.setPlayer(player);

        this.playerSubmissionService.createSubmission(submission);
    }

    @GetMapping("/sub/viewSubmission")
    public List<PlayerSubmission> getSubmissions(){
        return this.playerSubmissionService.getAllSubmissions();
    }
}
