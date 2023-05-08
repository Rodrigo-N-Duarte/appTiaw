package com.example.backend.repositories;

import com.example.backend.models.Empresa;
import com.example.backend.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    @Query(value = "select * from tb_empresa where email = :email", nativeQuery = true)
    Usuario emailJaExiste(String email);

    @Query(value = "select * from tb_empresa where nome like %:nome%", nativeQuery = true)
    List<Empresa> buscarEmpresaPorNome(String nome);
}
