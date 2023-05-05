package com.example.backend.repositories;

import com.example.backend.models.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {

    @Query(value = "select * from tb_mesa where id_empresa = :idEmpresa", nativeQuery = true)
    List<Mesa> buscarMesasPorEmpresa(Long idEmpresa);
}
