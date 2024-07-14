package com.ijse.springintro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ijse.springintro.entity.Task;
import com.ijse.springintro.controller.service.TaskService;


@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> taskList=taskService.getTaskList();
        return ResponseEntity.status(200).body(taskList);
    }

    @PostMapping("/tasks")
    public ResponseEntity<String> createTask(@RequestBody Task task) {
        if(task.getTaskName()==null || task.getTaskName()==""){
            return ResponseEntity.status(422).body("Please enter a valid task name");
            
        }
        if(task.getPriority()==null){
            return ResponseEntity.status(422).body("Enter a valid number as the priority");

        
    }
    taskService.createTask(task);
    return ResponseEntity.status(201).body("Task created successfully");
    }
    
    
}
