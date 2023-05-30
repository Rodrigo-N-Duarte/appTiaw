package com.example.backend.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "tb_empresa")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String nome;
    @Column
    private String email;
    @Column
    private String senha;
    @Column
    private String cnpj;
    @Column
    private String local;
    @Column
    private String telefone;
    @Column
    private Double avaliacao;
    @Column
    @Lob
    private String imagem;
    @OneToMany
    @JoinColumn(name = "id_empresa")
    @JsonManagedReference
    private List<Mesa> mesas;
    @OneToOne(mappedBy = "empresa")
    @JoinColumn(name = "id_empresa")
    private Cardapio cardapio;
}
