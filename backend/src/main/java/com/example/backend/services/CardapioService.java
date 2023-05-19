package com.example.backend.services;

import com.example.backend.models.Cardapio;
import com.example.backend.models.Empresa;
import com.example.backend.models.dto.CardapioDTO;
import com.example.backend.repositories.CardapioRepository;
import com.example.backend.repositories.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardapioService {
    private final CardapioRepository cardapioRepository;
    private final EmpresaRepository empresaRepository;
    public void adicionarCardapio(Cardapio cardapio){
        Empresa empresa = empresaRepository.findById(cardapio.getEmpresa().getId()).get();
        if (empresa.getCardapio() != null){
            return;
        }
        Cardapio novo = new Cardapio();
        novo.setEmpresa(empresaRepository.findById(cardapio.getEmpresa().getId()).get());

        cardapioRepository.save(novo);
    }
    public List<CardapioDTO> listarPorEmpresa(Long idEmpresa){
        List<Cardapio> cardapios = cardapioRepository.listarPorEmpresa(idEmpresa);
        List<CardapioDTO> dtos = new ArrayList<>();
        cardapios.forEach(cardapio -> {
            CardapioDTO dto = new CardapioDTO();
            dto.setId(cardapio.getId());
            dto.setId_empresa(cardapio.getEmpresa().getId());
            dtos.add(dto);
        });
        return dtos;
    }
}
