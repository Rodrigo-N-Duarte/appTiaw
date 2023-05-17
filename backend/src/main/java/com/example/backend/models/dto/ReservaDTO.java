package com.example.backend.models.dto;

import com.example.backend.models.Mesa;
import com.example.backend.models.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ReservaDTO {
    private Long id;
    private String data;
    private String hora;
    private Long usuario;
    private Long mesa;
    private String numero_mesa;
    private String nome_empresa;
}
