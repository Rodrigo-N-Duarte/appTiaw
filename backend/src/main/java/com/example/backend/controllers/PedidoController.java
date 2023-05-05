package com.example.backend.controllers;

import com.example.backend.models.Pedido;
import com.example.backend.services.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedido")
public class PedidoController {
    private final PedidoService pedidoService;
    @PostMapping("/cadastrar")
    public void cadastrarPedido(@RequestBody Pedido pedido){
        pedidoService.cadastraPedido(pedido);
    }
}
