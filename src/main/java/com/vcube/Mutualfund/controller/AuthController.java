package com.vcube.Mutualfund.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.vcube.Mutualfund.Security.JwtUtil;
import com.vcube.Mutualfund.dto.LoginRequest;
import com.vcube.Mutualfund.entity.User;
import com.vcube.Mutualfund.repo.UserRepository;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;   // ✅ ADD THIS

    @Autowired
    private PasswordEncoder passwordEncoder; // ✅ ADD THIS

    // 🔹 REGISTER API ✅
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            if (user.getRole() == null) {
                user.setRole("ROLE_USER");
            }

            userRepository.save(user);

            return "User registered successfully";

        } catch (Exception e) {
            e.printStackTrace(); // 🔥 CHECK THIS IN CONSOLE
            return "Error: " + e.getMessage();
        }
    }

    // 🔹 LOGIN API (already exists)
   

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail());

        if (user == null) {
            return ResponseEntity.status(404).body("User not found");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).body("Invalid password");
        }

        // ✅ Generate token
        String token = jwtUtil.generateToken(user.getEmail());

        // ✅ Send token in response
        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return ResponseEntity.ok(response);
    }
}