package com.example.backend.services;

import com.example.backend.models.Empresa;
import com.example.backend.models.Mesa;
import com.example.backend.repositories.EmpresaRepository;
import com.example.backend.repositories.MesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MesaService {
    private final MesaRepository mesaRepository;
    private final EmpresaRepository empresaRepository;

    public void cadastrarMesa(Mesa mesa){
        Mesa nova = new Mesa();
        nova.setDisponivel(mesa.getDisponivel());
        nova.setNumero(mesa.getNumero());
        Empresa empresa = empresaRepository.findById(mesa.getEmpresa().getId()).get();
        nova.setEmpresa(empresa);

        mesaRepository.save(nova);
    }

    public List<Mesa> buscarMesaPorEmpresa(Long idEmpresa){
        return mesaRepository.buscarMesasPorEmpresa(idEmpresa);
    }
    public void excluirMesa(Long id){
        mesaRepository.deleteById(id);
    }
    public void alterarDisponibilidade(Long id){
        Mesa mesa = mesaRepository.findById(id).get();
        mesa.setDisponivel(!mesa.getDisponivel());
        mesaRepository.save(mesa);
    }
}
