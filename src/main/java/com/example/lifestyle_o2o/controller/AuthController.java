package com.example.lifestyle_o2o.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.lifestyle_o2o.dto.AuthRequest;
import com.example.lifestyle_o2o.dto.AuthResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest authRequest) {
        // Registration logic
        return new ResponseEntity<>(new AuthResponse("User registered successfully."), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        // Login logic
        return new ResponseEntity<>(new AuthResponse("User logged in successfully."), HttpStatus.OK);
    }
}