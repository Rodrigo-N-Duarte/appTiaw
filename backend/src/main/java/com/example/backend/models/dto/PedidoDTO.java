package com.example.backend.models.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PedidoDTO implements Serializable {
    private Long id;
    private Boolean pago;
    private String data;
    private String hora;
    private Long id_usuario;
    private Long id_empresa;
    private List<ItemDTO> id_itens;
}
