package com.example.saikiran.taskmanagement.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.saikiran.taskmanagement.Entity.User;
import com.example.saikiran.taskmanagement.dto.LoginRequest;
import com.example.saikiran.taskmanagement.dto.RegisterRequest;
import com.example.saikiran.taskmanagement.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
        
        
        return ResponseEntity.ok(userService.registerUser(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
       boolean isValid =userService.validateUser(request.getEmail(), request.getPassword());
        if (isValid) return ResponseEntity.ok("Login Sucess");
        return ResponseEntity.status(401).body("Invalid credentials");
    }
    
    

    


}
