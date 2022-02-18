package com.cron.codechallenger.controller;

import com.cron.codechallenger.data.projections.PlayerTasks;
import com.cron.codechallenger.model.Task;
import com.cron.codechallenger.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TaskController {

    TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @CrossOrigin
    @GetMapping("/tasks")
    public List<Task> getTasks(){
        return this.taskService.getTasks();
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/task")
    public void createTask(@RequestBody Task task){
        this.taskService.createTask(task);
    }


    @CrossOrigin
    @GetMapping("/tasks/{id}")
    public List<PlayerTasks> getTasksById(@PathVariable long id){
        return this.taskService.getTasksByPlayerId(id);
    }
}
