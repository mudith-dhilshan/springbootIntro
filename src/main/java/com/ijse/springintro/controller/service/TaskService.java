package com.ijse.springintro.controller.service;

import com.ijse.springintro.entity.Task;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface TaskService {

     List<Task> getTaskList();
     Task createTask(Task task);
    Task getTaskById(Long id);
    
}
