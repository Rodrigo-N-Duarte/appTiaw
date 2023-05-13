package com.example.backend.services;

import com.example.backend.models.Empresa;
import com.example.backend.models.Usuario;
import com.example.backend.models.dto.AuthDTO;
import com.example.backend.models.dto.UsuarioDTO;
import com.example.backend.repositories.EmpresaRepository;
import com.example.backend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioDTO fazerLoginUsuario(String email, String senha){
        List<Usuario> usuarios = usuarioRepository.findAll();
        for (Usuario usuario : usuarios)  {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)){
                UsuarioDTO dto = new UsuarioDTO();
                dto.setId(usuario.getId());
                dto.setEmail(usuario.getEmail());
                dto.setNome(usuario.getNome());
                return dto;
            }
        }
        return null;
    }
}
