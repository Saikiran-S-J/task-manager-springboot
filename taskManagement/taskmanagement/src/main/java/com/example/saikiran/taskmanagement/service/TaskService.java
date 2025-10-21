package com.example.saikiran.taskmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.saikiran.taskmanagement.Entity.Task;
import com.example.saikiran.taskmanagement.Entity.User;
import com.example.saikiran.taskmanagement.repository.TaskRepository;
import com.example.saikiran.taskmanagement.repository.UserRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepo;

    private final UserRepository userRepo;

    public TaskService(TaskRepository taskRepo, UserRepository userRepo) {
        this.taskRepo = taskRepo;
        this.userRepo = userRepo;
    }


    public Task createTask(Long userId, Task task){
        User user = userRepo.findById(userId).orElseThrow();
        task.setUser(user);
        task.setStatus("Pending");
        return taskRepo.save(task);
    }

    public List<Task> getTaskByUser(Long userId){
        return taskRepo.findByUserId(userId);
    }


    public Task updateTask(Long id, Task updatedTask){
        Task existing = taskRepo.findById(id).orElseThrow();
        existing.setTitle(updatedTask.getTitle());
        existing.setDescription(updatedTask.getDescription());
        existing.setStatus(updatedTask.getStatus());
        existing.setDueDate(updatedTask.getDueDate());
        return taskRepo.save(existing);
    }

    public void deleteTask(Long id){
        taskRepo.deleteById(id);
    }
    public List<Task> filterTasksByStatus(Long userId, String status){
        return taskRepo.findByUserIdAndStatus(userId, status);
    }

}
