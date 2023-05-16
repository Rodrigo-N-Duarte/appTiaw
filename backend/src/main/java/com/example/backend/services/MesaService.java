package com.example.backend.services;

import com.example.backend.models.Empresa;
import com.example.backend.models.Mesa;
import com.example.backend.models.dto.MesaDTO;
import com.example.backend.models.dto.ReservaDTO;
import com.example.backend.repositories.EmpresaRepository;
import com.example.backend.repositories.MesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<MesaDTO> buscarMesaPorEmpresa(Long idEmpresa){
        List<Mesa> mesas = mesaRepository.buscarMesasPorEmpresa(idEmpresa);
        List<MesaDTO> dtos = new ArrayList<>();
        mesas.forEach(mesa -> {
            MesaDTO dto = new MesaDTO();
            dto.setId(mesa.getId());
            dto.setNumero(mesa.getNumero());
            dto.setDisponivel(mesa.getDisponivel());
            dto.setId_empresa(mesa.getEmpresa().getId());
            if (mesa.getReserva() != null){
                dto.setId_reserva(mesa.getReserva().getId());
            }
            else dto.setId_reserva(null);
            dtos.add(dto);
        });
        return dtos;
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
