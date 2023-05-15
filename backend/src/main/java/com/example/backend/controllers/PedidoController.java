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
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/cadastrar")
    public void cadastrarPedido(@RequestBody Pedido pedido){
        pedidoService.cadastraPedido(pedido);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/buscar-por-usuario/{id}")
    public List<PedidoDTO> buscarPorUsuario(@PathVariable("id") Long id){
        return pedidoService.buscarPorUsuario(id);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/buscar/{id}")
    public PedidoDTO buscaPorId(@PathVariable("id") Long id){
        return pedidoService.buscarPorId(id);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/buscar")
    public List<PedidoDTO> buscaTodos(){
        return pedidoService.buscaTodos();
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{idPedido}/adicionar-item/{idItem}")
    public void adicionarItem(@PathVariable("idPedido") Long idPedido, @PathVariable("idItem") Long idItem){
        pedidoService.adicionarItem(idPedido, idItem);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/finalizar/{idPedido}")
    public void adicionarItem(@PathVariable("idPedido") Long idPedido, @RequestBody Pedido pedido){
        pedidoService.finalizarPedido(idPedido, pedido);
    }
}
