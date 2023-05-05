package com.example.backend.controllers;

import com.example.backend.models.Empresa;
import com.example.backend.models.dto.EmpresaDTO;
import com.example.backend.services.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
@RequiredArgsConstructor
public class EmpresaController {
    private final EmpresaService empresaService;
    @GetMapping("/buscar")
    public List<EmpresaDTO> buscarEmpresas(){
        return empresaService.buscarEmpresas();
    }
    @PostMapping("/cadastrar")
    public void cadastrarEmpresa(@RequestBody Empresa empresa){
        empresaService.cadastrarEmpresa(empresa);
    }
    @PutMapping("/avaliacao/{id}/alterar/{avaliacao}")
    public void alterarAvaliacao(@PathVariable("id") Long id, @PathVariable("avaliacao") Double avaliacao){
        empresaService.alterarAvaliacao(id, avaliacao);
    }
}
