package com.example.fundoonotes.controller;

import com.example.fundoonotes.dto.AuthResponse;
import com.example.fundoonotes.dto.RegisterRequest;
import com.example.fundoonotes.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/userSignUp")
    public ResponseEntity<AuthResponse> register(
            @Valid @RequestBody RegisterRequest request) {
        String token = userService.registerUser(request);
        AuthResponse response = new AuthResponse(token);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
