package com.example.backend.services;

import com.example.backend.models.Usuario;
import com.example.backend.models.dto.UsuarioDTO;
import com.example.backend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public void cadastraUsuario(Usuario usuario){
        if (usuarioRepository.emailJaExiste(usuario.getEmail()) != null){
            return;
        }
        Usuario novo = new Usuario();
        novo.setNome(usuario.getNome());
        novo.setEmail(usuario.getEmail());
        novo.setSenha(usuario.getSenha());

        usuarioRepository.save(novo);
    }

    public UsuarioDTO buscaUsuarioPorId(Long id){
        Usuario usuario = usuarioRepository.findById(id).get();
        UsuarioDTO dto = new UsuarioDTO();

        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        return dto;
    }
}
