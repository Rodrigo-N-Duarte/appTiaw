package com.example.backend.repositories;

import com.example.backend.models.Cardapio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Long> {
    @Query(value = "select * from tb_cardapio where id_empresa = :idEmpresa", nativeQuery = true)
    List<Cardapio> listarPorEmpresa(Long idEmpresa);
}
