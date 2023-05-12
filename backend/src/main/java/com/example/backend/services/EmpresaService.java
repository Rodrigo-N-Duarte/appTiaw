package com.example.backend.services;

import com.example.backend.models.Cardapio;
import com.example.backend.models.Empresa;
import com.example.backend.models.dto.EmpresaDTO;
import com.example.backend.repositories.CardapioRepository;
import com.example.backend.repositories.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpresaService {
    private final EmpresaRepository empresaRepository;
    private final CardapioService cardapioService;
    private final CardapioRepository cardapioRepository;

    public List<EmpresaDTO> buscarEmpresas(){
        List<Empresa> empresas = empresaRepository.findAll();
        List<EmpresaDTO> empresasDTO = new ArrayList<>();

        empresas.forEach(empresa -> {
            EmpresaDTO dto = new EmpresaDTO();
            dto.setId(empresa.getId());
            dto.setNome(empresa.getNome());
            dto.setEmail(empresa.getEmail());
            dto.setCnpj(empresa.getCnpj());
            dto.setLocal(empresa.getLocal());
            dto.setTelefone(empresa.getTelefone());
            dto.setAvaliacao(empresa.getAvaliacao());

            empresasDTO.add(dto);
        });
        return empresasDTO;
    }
    public List<EmpresaDTO> buscarEmpresaPorNome(String nome){
        List<Empresa> empresas = empresaRepository.buscarEmpresaPorNome(nome);
        List<EmpresaDTO> empresasDTO = new ArrayList<>();

        empresas.forEach(empresa -> {
            EmpresaDTO dto = new EmpresaDTO();
            dto.setId(empresa.getId());
            dto.setNome(empresa.getNome());
            dto.setEmail(empresa.getEmail());
            dto.setCnpj(empresa.getCnpj());
            dto.setLocal(empresa.getLocal());
            dto.setTelefone(empresa.getTelefone());
            dto.setAvaliacao(empresa.getAvaliacao());

            empresasDTO.add(dto);
        });
        return empresasDTO;
    }
    public EmpresaDTO buscarEmpresaPorId(Long id){
        EmpresaDTO dto = new EmpresaDTO();
        Empresa empresa = empresaRepository.findById(id).get();
        dto.setId(empresa.getId());
        dto.setNome(empresa.getNome());
        dto.setEmail(empresa.getEmail());
        dto.setCnpj(empresa.getCnpj());
        dto.setLocal(empresa.getLocal());
        dto.setTelefone(empresa.getTelefone());
        dto.setAvaliacao(empresa.getAvaliacao());

        return dto;
    }
    public String cadastrarEmpresa(Empresa empresa){
        if (empresaRepository.emailJaExiste(empresa.getEmail()) != null){
            return "Email já existe";
        }
        Empresa nova = new Empresa();
        nova.setNome(empresa.getNome());
        nova.setEmail(empresa.getEmail());
        nova.setSenha(empresa.getSenha());
        nova.setCnpj(empresa.getCnpj());
        nova.setLocal(empresa.getLocal());
        nova.setTelefone(empresa.getTelefone());
        nova.setAvaliacao(empresa.getAvaliacao());


        empresaRepository.save(nova);
        Cardapio cardapio = new Cardapio();
        cardapio.setEmpresa(nova);
        cardapioRepository.save(cardapio);
        return "Empresa cadastrada com sucesso!";
    }

    public void alterarAvaliacao(Long id, Double avaliacao){
        Empresa empresa = empresaRepository.findById(id).get();

        empresa.setAvaliacao((double) Math.round((empresa.getAvaliacao() + avaliacao) / 2));
        empresaRepository.save(empresa);
    }
}
