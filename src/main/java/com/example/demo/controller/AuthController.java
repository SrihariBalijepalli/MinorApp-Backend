package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    // 🟢 REGISTER
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.register(user);
    }

    // 🔵 LOGIN
    @PostMapping("/login")
    public User login(
            @RequestParam String email,
            @RequestParam String password) {

        return authService.login(email, password);
    }
}