package com.example.backend.controllers;

import com.example.backend.models.Mesa;
import com.example.backend.services.MesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesa")
@RequiredArgsConstructor
public class MesaController {
    private final MesaService mesaService;
    @GetMapping("/buscar-mesa-por-empresa/{idEmpresa}")
    public List<Mesa> buscarMesaPorEmpresa(@PathVariable("idEmpresa") Long idEmpresa){
        return mesaService.buscarMesaPorEmpresa(idEmpresa);
    }
    @PostMapping("/cadastrar")
    public void cadastrarMesa(@RequestBody Mesa mesa){
        mesaService.cadastrarMesa(mesa);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluirMesa(@PathVariable("id") Long id){
        mesaService.excluirMesa(id);
    }

    @PutMapping("/alterar-disponibilidade/{id}")
    public void alterarDisponibilidade(@PathVariable("id") Long id){
        mesaService.alterarDisponibilidade(id);
    }
}
