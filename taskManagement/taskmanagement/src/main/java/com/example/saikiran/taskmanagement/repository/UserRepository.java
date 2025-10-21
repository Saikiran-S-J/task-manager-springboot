package com.example.saikiran.taskmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.saikiran.taskmanagement.Entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByEmail(String email);

}
