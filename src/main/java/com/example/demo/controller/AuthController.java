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
            @RequestParam("email") String email,
            @RequestParam("password") String password) {

        return authService.login(email, password);
    }

    // ✏️ UPDATE
    @PutMapping("/update")
    public User update(
            @RequestParam("email") String email,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "targetRole", required = false) String targetRole) {
        
        return authService.updateUser(email, name, password, targetRole);
    }
}