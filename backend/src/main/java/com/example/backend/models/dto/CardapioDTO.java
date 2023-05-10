package com.example.backend.models.dto;

import com.example.backend.models.Item;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class CardapioDTO implements Serializable {
    private Long id;
    private Long id_empresa;
    private List<Item> itens;
}
