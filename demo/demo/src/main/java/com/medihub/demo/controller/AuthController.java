package com.medihub.demo.controller;

import com.medihub.demo.entity.User;
import com.medihub.demo.dto.LoginRequest;
import com.medihub.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User u){
        if(userService.findByEmail(u.getEmail()).isPresent()){
            return ResponseEntity.badRequest().body("Email already in use");
        }
        u.setRole(u.getRole() == null ? "patient" : u.getRole());
        User saved = userService.save(u);
        saved.setPassword(null); // hide password
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req){
        Optional<User> opt = userService.findByEmail(req.getEmail());
        if(opt.isEmpty()) return ResponseEntity.status(401).body("Invalid credentials");
        User u = opt.get();
        if(!u.getPassword().equals(req.getPassword())) return ResponseEntity.status(401).body("Invalid credentials");
        u.setPassword(null);
        return ResponseEntity.ok(u);
    }
}
