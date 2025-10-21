package com.example.saikiran.taskmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.saikiran.taskmanagement.Entity.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findByUserId(Long userId);
    List<Task> findByUserIdAndStatus(Long userId, String status);

}
