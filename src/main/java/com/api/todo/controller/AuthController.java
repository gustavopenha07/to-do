package com.api.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.todo.dto.MessageResponseDTO;
import com.api.todo.dto.UserRegisterRequestDTO;
import com.api.todo.service.AuthService;

@RequestMapping("/auth")
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<MessageResponseDTO> register(@RequestBody UserRegisterRequestDTO request) {

    this.authService.registerUser(request.name(), request.username(), request.password());

    return ResponseEntity.status(HttpStatus.CREATED)
            .body(new MessageResponseDTO("Usuário registrado com sucesso!"));
    }

    @PostMapping("/login")
    public ResponseEntity<MessageResponseDTO> login() {
        return ResponseEntity.ok(new MessageResponseDTO("Login realizado com sucesso"));
    }
}
