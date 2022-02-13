package com.cron.codechallenger.service;

import com.cron.codechallenger.model.Task;
import com.cron.codechallenger.data.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask(Task task){
        this.taskRepository.save(task);
    }

    public List<Task> getTasks(){
        List<Task> listOfTasks =  new ArrayList<>();
        this.taskRepository.findAll().forEach(listOfTasks::add);

        return listOfTasks;
    }

    public Task getTask(long id){
        return this.taskRepository.findById(id).get();
    }
}
