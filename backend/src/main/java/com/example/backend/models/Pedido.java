package com.example.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
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
@Table(name = "tb_pedido")
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Boolean pago;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;
    @ManyToMany
    @JoinTable(name = "tb_item_pedido",
            joinColumns = @JoinColumn(name = "pedido_fk"),
            inverseJoinColumns = @JoinColumn(name = "item_fk"))
    private Set<Item> itens = new HashSet<>();
}
