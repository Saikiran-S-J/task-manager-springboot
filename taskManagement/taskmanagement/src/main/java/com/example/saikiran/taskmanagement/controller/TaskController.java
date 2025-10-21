package com.example.saikiran.taskmanagement.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.saikiran.taskmanagement.Entity.Task;
import com.example.saikiran.taskmanagement.service.TaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/tasks")
@CrossOrigin("*")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestParam Long userId, @RequestBody Task task) {
        return ResponseEntity.ok(taskService.createTask(userId, task));
    }

     @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        return ResponseEntity.ok(taskService.updateTask(id, task));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted sucessfully");
    }


    @GetMapping("/filter")
    public ResponseEntity<List> filterByStatus(@RequestParam Long userId, @RequestParam String status) {
        return ResponseEntity.ok(taskService.filterTasksByStatus(userId, status));
    }
    
    

}
