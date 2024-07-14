package com.ijse.springintro.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.springintro.entity.Task;
import com.ijse.springintro.controller.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getTaskList() {
        return taskRepository.findAll();
}

@Override
public Task createTask(Task task) {
    return taskRepository.save(task);
}

@Override
public Task getTaskById(Long id) {
    return taskRepository.findById(id).orElse(null);


}
}
