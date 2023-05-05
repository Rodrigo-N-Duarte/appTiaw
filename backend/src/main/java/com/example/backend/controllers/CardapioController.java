package com.example.backend.controllers;

import com.example.backend.models.Cardapio;
import com.example.backend.services.CardapioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cardapio")
public class CardapioController {
    private final CardapioService cardapioService;
    @PostMapping("/adicionar")
    public void adicionarCardapio(@RequestBody Cardapio cardapio){
        cardapioService.adicionarCardapio(cardapio);
    }
    @GetMapping("/listar-por-empresa/{idEmpresa}")
    public List<Cardapio> listarPorEmpresa(@PathVariable("idEmpresa") Long idEmpresa){
        return cardapioService.listarPorEmpresa(idEmpresa);
    }
}
