package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.exception.BadRequestException;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    // 🔐 REGISTER
    public User register(User user) {

        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new BadRequestException("Email already exists");
        }

        return userRepository.save(user);
    }

    // 🔐 LOGIN
    public User login(String email, String password) {

        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new BadRequestException("User not found");
        }

        if (!user.getPassword().equals(password)) {
            throw new BadRequestException("Invalid password");
        }

        return user;
    }

    // ✏️ UPDATE
    public User updateUser(String email, String name, String password, String targetRole) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new BadRequestException("User not found");
        }
        
        if (name != null && !name.trim().isEmpty()) {
            user.setName(name);
        }
        if (password != null && !password.trim().isEmpty()) {
            user.setPassword(password);
        }
        if (targetRole != null && !targetRole.trim().isEmpty()) {
            user.setTargetRole(targetRole);
        }
        
        return userRepository.save(user);
    }
}