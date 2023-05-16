package com.example.backend.controllers;

import com.example.backend.models.Mesa;
import com.example.backend.models.dto.MesaDTO;
import com.example.backend.services.MesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesa")
@RequiredArgsConstructor
public class MesaController {
    private final MesaService mesaService;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/buscar-mesa-por-empresa/{idEmpresa}")
    public List<MesaDTO> buscarMesaPorEmpresa(@PathVariable("idEmpresa") Long idEmpresa){
        return mesaService.buscarMesaPorEmpresa(idEmpresa);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/cadastrar")
    public void cadastrarMesa(@RequestBody Mesa mesa){
        mesaService.cadastrarMesa(mesa);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/excluir/{id}")
    public void excluirMesa(@PathVariable("id") Long id){
        mesaService.excluirMesa(id);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/alterar-disponibilidade/{id}")
    public void alterarDisponibilidade(@PathVariable("id") Long id){
        mesaService.alterarDisponibilidade(id);
    }
}
