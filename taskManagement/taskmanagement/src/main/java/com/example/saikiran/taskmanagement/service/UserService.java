package com.example.saikiran.taskmanagement.service;

import org.springframework.stereotype.Service;

import com.example.saikiran.taskmanagement.Entity.User;
import com.example.saikiran.taskmanagement.dto.RegisterRequest;
import com.example.saikiran.taskmanagement.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User registerUser(RegisterRequest request){
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return userRepo.save(user);
    }

    public boolean validateUser(String email, String password){
        return userRepo.findByEmail(email)
        .map(u -> u.getPassword().equals(password))
        .orElse(false);
    }

}
