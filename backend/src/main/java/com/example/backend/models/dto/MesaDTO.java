package com.example.backend.models.dto;

import com.example.backend.models.Empresa;
import com.example.backend.models.Reserva;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MesaDTO {
    private Long id;
    private Boolean disponivel;
    private String numero;
    private Long id_empresa;
    private Long id_reserva;
}
