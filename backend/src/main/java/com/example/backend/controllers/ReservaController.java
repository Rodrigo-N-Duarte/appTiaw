package com.example.backend.controllers;

import com.example.backend.models.Reserva;
import com.example.backend.models.dto.ReservaDTO;
import com.example.backend.models.dto.UsuarioDTO;
import com.example.backend.services.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reserva")
public class ReservaController {
    private final ReservaService reservaService;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/adicionar")
    public String adicionarReserva(@RequestBody Reserva reserva){
        return reservaService.adicionarReserva(reserva);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/buscar-por-usuario/{idUsuario}")
    public List<ReservaDTO> buscarReservasPorUsuario(@PathVariable("idUsuario") Long idUsuario){
        return reservaService.buscarReservasPorUsuario(idUsuario);
    }
}
