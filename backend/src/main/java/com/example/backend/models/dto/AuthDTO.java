package com.example.backend.models.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
public class AuthDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String email;
    private String tipo;
    private Boolean logado = false;
}
