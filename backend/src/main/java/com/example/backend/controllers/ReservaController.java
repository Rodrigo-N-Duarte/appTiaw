package com.example.backend.controllers;

import com.example.backend.models.Reserva;
import com.example.backend.services.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reserva")
public class ReservaController {
    private final ReservaService reservaService;
    @PostMapping("/adicionar")
    public String adicionarReserva(@RequestBody Reserva reserva){
        return reservaService.adicionarReserva(reserva);
    }
}
