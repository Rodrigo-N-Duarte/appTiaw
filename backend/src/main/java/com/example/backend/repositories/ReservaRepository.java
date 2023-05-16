package com.example.backend.repositories;

import com.example.backend.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    @Query(value = "select * from tb_reserva r where r.id_usuario = :idUsuario", nativeQuery = true)
    List<Reserva> buscarReservasPorUsuario(Long idUsuario);
}
