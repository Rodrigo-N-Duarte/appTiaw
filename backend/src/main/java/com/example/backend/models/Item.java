package com.example.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.Fetch;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "tb_item")
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String nome;
    @Column
    private double preco;
    @ManyToOne
    @JoinColumn(name = "id_cardapio")
    private Cardapio cardapio;
    @JsonIgnore
    @ManyToMany(mappedBy = "itens")
    private Set<Pedido> pedidos = new HashSet<>();
}
