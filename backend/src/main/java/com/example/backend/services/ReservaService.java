package com.example.backend.services;

import com.example.backend.models.Empresa;
import com.example.backend.models.Mesa;
import com.example.backend.models.Reserva;
import com.example.backend.models.Usuario;
import com.example.backend.models.dto.EmpresaDTO;
import com.example.backend.models.dto.ReservaDTO;
import com.example.backend.repositories.MesaRepository;
import com.example.backend.repositories.ReservaRepository;
import com.example.backend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final MesaRepository mesaRepository;
    private final MesaService mesaService;
    private final UsuarioRepository usuarioRepository;
    private final EmpresaService empresaService;

    public String adicionarReserva(Reserva reserva){
        Mesa mesaRequisitada = mesaRepository.findById(reserva.getMesa().getId()).get();
        if(!mesaRequisitada.getDisponivel()){
            return "Mesa já reservada ou ocupada no momento.";
        }
        Reserva nova = new Reserva();
        nova.setData(reserva.getData());
        nova.setHora(reserva.getHora());
        nova.setMesa(mesaRequisitada);

        Usuario usuario = usuarioRepository.findById(reserva.getUsuario().getId()).get();
        nova.setUsuario(usuario);

        reservaRepository.save(nova);

        return "Sua reserva foi feita com sucesso na mesa de número: " + mesaRequisitada.getNumero();
    }
    public List<ReservaDTO> buscarReservasPorUsuario(Long idUsuario){
        List<Reserva> reservas = reservaRepository.buscarReservasPorUsuario(idUsuario);
        List<ReservaDTO> dtos = new ArrayList<>();
        reservas.forEach(reserva -> {
            ReservaDTO dto = new ReservaDTO();
            dto.setId(reserva.getId());
            dto.setUsuario(reserva.getUsuario().getId());
            dto.setData(reserva.getData());
            dto.setHora(reserva.getHora());
            dto.setMesa(reserva.getMesa().getId());
            dto.setNumero_mesa(reserva.getMesa().getNumero());
            EmpresaDTO empresa = empresaService.buscarEmpresaPorId(reserva.getMesa().getEmpresa().getId());
            dto.setNome_empresa(empresa.getNome());
            dtos.add(dto);
        });
        return dtos;
    }

    public void excluirReserva(Long id){
        Reserva reserva = reservaRepository.findById(id).get();
        Long idMesa = reserva.getMesa().getId();
        mesaService.alterarDisponibilidade(idMesa);
        reservaRepository.deleteById(id);
    }
}
