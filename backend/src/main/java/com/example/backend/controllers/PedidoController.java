package com.example.backend.controllers;

import com.example.backend.models.Pedido;
import com.example.backend.models.dto.PedidoDTO;
import com.example.backend.services.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedido")
public class PedidoController {
    private final PedidoService pedidoService;
    @PostMapping("/cadastrar")
    public void cadastrarPedido(@RequestBody Pedido pedido){
        pedidoService.cadastraPedido(pedido);
    }

    @GetMapping("/buscar-por-usuario/{id}")
    public List<PedidoDTO> buscarPorUsuario(@PathVariable("id") Long id){
        return pedidoService.buscarPorUsuario(id);
    }
    @GetMapping("/buscar/{id}")
    public PedidoDTO buscaPorId(@PathVariable("id") Long id){
        return pedidoService.buscarPorId(id);
    }
    @GetMapping("/buscar")
    public List<PedidoDTO> buscaTodos(){
        return pedidoService.buscaTodos();
    }
    @PutMapping("/{idPedido}/adicionar-item/{idItem}")
    public void adicionarItem(@PathVariable("idPedido") Long idPedido, @PathVariable("idItem") Long idItem){
        pedidoService.adicionarItem(idPedido, idItem);
    }
}
