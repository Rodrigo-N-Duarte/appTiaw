package com.example.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.ArrayList;
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
    private Long id_item;
    @Column
    private String nome;
    @Column
    private double preco;
    @ManyToOne
    @JoinColumn(name = "id_cardapio")
    private Cardapio cardapio;
    @ManyToMany
    @JoinTable(name = "tb_item_pedido",
            joinColumns = @JoinColumn(name = "item_fk"),
            inverseJoinColumns = @JoinColumn(name = "pedido_fk"))
    private List<Pedido> pedidos = new ArrayList<>();
}
