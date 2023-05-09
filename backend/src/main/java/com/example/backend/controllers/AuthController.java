package com.example.backend.controllers;

import com.example.backend.models.Usuario;
import com.example.backend.models.dto.AuthDTO;
import com.example.backend.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/login")
    public AuthDTO fazerLogin(@RequestBody Usuario user){
        String email = user.getEmail(), senha = user.getSenha();
        return authService.fazerLogin(email, senha);
    }
}
