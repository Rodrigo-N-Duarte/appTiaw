package com.example.backend.models.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ItemDTO implements Serializable {
    private Long id;
    private String nome;
    private Double preco;
    private Long id_cardapio;
}
