package com.example.backend.services;

import com.example.backend.models.Mesa;
import com.example.backend.models.Reserva;
import com.example.backend.models.Usuario;
import com.example.backend.repositories.MesaRepository;
import com.example.backend.repositories.ReservaRepository;
import com.example.backend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final MesaRepository mesaRepository;
    private final UsuarioRepository usuarioRepository;

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
}
