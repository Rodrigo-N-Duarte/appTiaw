package com.example.backend.controllers;

import com.example.backend.models.Usuario;
import com.example.backend.models.dto.UsuarioDTO;
import com.example.backend.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/cadastrar")
    public void cadastraUsuario(@RequestBody Usuario usuario){
        usuarioService.cadastraUsuario(usuario);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/buscar/{id}")
    public UsuarioDTO buscaPorId(@PathVariable("id") Long id){
        return usuarioService.buscaUsuarioPorId(id);
    }
}
