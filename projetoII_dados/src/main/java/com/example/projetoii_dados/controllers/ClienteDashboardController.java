package com.example.projetoii_dados.controllers;

import com.example.core.models.*;
import com.example.projetoii_dados.services.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes/{idCliente}")
public class ClienteDashboardController {

    private final ReservaService reservaService;
    private final EventoService eventoService;
    private final FaturaService faturaService;
    private final ReciboService reciboService;

    public ClienteDashboardController(
            ReservaService reservaService,
            EventoService eventoService,
            FaturaService faturaService,
            ReciboService reciboService
    ) {
        this.reservaService = reservaService;
        this.eventoService = eventoService;
        this.faturaService = faturaService;
        this.reciboService = reciboService;
    }

    @GetMapping("/reservas")
    public List<Reserva> getReservas(@PathVariable Integer idCliente) {
        return reservaService.findByClienteId(idCliente);
    }

    @GetMapping("/eventos")
    public List<Evento> getEventos(@PathVariable Integer idCliente) {
        return eventoService.findByClienteId(idCliente);
    }

    @GetMapping("/faturas")
    public List<Fatura> getFaturas(@PathVariable Integer idCliente) {
        return faturaService.findByClienteId(idCliente);
    }

    @GetMapping("/recibos")
    public List<Recibo> getRecibos(@PathVariable Integer idCliente) {
        return reciboService.findByClienteId(idCliente);
    }
}
