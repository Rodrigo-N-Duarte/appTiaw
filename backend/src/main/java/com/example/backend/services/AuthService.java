package com.example.backend.services;

import com.example.backend.models.Empresa;
import com.example.backend.models.Usuario;
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
    private final EmpresaRepository empresaRepository;

    public Boolean fazerLogin(String email, String senha){
        List<Usuario> usuarios = usuarioRepository.findAll();
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)){
                return true;
            }
        }
        List<Empresa> empresas = empresaRepository.findAll();
        for (Empresa empresa : empresas) {
            if (empresa.getEmail().equals(email) && empresa.getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }
}
