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
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/buscar")
    public List<EmpresaDTO> buscarEmpresas(){
        return empresaService.buscarEmpresas();
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/buscar-por-nome/{nome}")
    public List<EmpresaDTO> buscarEmpresas(@PathVariable("nome") String nome){
        return empresaService.buscarEmpresaPorNome(nome);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/buscar/{id}")
    public EmpresaDTO buscarEmpresas(@PathVariable("id") Long id){
        return empresaService.buscarEmpresaPorId(id);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/cadastrar")
    public String cadastrarEmpresa(@RequestBody Empresa empresa){
        return empresaService.cadastrarEmpresa(empresa);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/avaliacao/{id}/alterar/{avaliacao}")
    public void alterarAvaliacao(@PathVariable("id") Long id, @PathVariable("avaliacao") Double avaliacao){
        empresaService.alterarAvaliacao(id, avaliacao);
    }
}
