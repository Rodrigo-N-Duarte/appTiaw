package com.example.backend.services;

import com.example.backend.models.Cardapio;
import com.example.backend.models.Empresa;
import com.example.backend.repositories.CardapioRepository;
import com.example.backend.repositories.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public List<Cardapio> listarPorEmpresa(Long idEmpresa){
        return cardapioRepository.listarPorEmpresa(idEmpresa);
    }
}
