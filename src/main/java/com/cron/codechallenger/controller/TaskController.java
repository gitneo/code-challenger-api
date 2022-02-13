package com.cron.codechallenger.controller;

import com.cron.codechallenger.model.Task;
import com.cron.codechallenger.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/tasks")
    public List<Task> getTask(){
        return this.taskService.getTasks();
    }

    @PostMapping("/task")
    public void createTask(@RequestBody Task task){
        this.taskService.createTask(task);
    }
}
