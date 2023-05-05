package com.example.backend.models.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
public class EmpresaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String nome;
    private String email;
    private String local;
    private String telefone;
    private String cnpj;
    private Double avaliacao;
}
