package com.example.backend.repositories;

import com.example.backend.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(value = "select * from tb_usuario where email = :email", nativeQuery = true)
    Usuario emailJaExiste(String email);
}
