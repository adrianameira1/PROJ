package com.example.projetoii_dados.controllers;

import com.example.core.models.Evento;
import com.example.core.models.Reserva;
import com.example.core.models.Tipoevento;
import com.example.core.repositories.ReservaRepository;
import com.example.core.repositories.TipoEventoRepository;
import com.example.projetoii_dados.DTOs.EventoDTO;
import com.example.projetoii_dados.services.EventoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/eventos")
@Tag(name = "Eventos", description = "Endpoints para manipular eventos")
public class EventoController {

    private final EventoService eventoService;
    private final ReservaRepository reservaRepository;
    private final TipoEventoRepository tipoeventoRepository;

    public EventoController(EventoService eventoService,
                            ReservaRepository reservaRepository,
                            TipoEventoRepository tipoEventoRepository) {
        this.eventoService = eventoService;
        this.reservaRepository = reservaRepository;
        this.tipoeventoRepository = tipoEventoRepository;
    }

    @GetMapping
    public List<EventoDTO> getAllEventos() {
        return eventoService.findAll().stream()
                .map(e -> new EventoDTO(
                        e.getOrcamento(),
                        e.getCronograma(),
                        e.getStatusevento(),
                        e.getIdReserva().getId(),
                        e.getIdTipoevento().getId()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoDTO> getEventoById(@PathVariable Integer id) {
        Evento evento = eventoService.findById(id);
        if (evento == null) return ResponseEntity.notFound().build();

        EventoDTO dto = new EventoDTO(
                evento.getOrcamento(),
                evento.getCronograma(),
                evento.getStatusevento(),
                evento.getIdReserva().getId(),
                evento.getIdTipoevento().getId()
        );
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<Void> createEvento(@RequestBody EventoDTO dto) {
        Reserva reserva = reservaRepository.findById(dto.getIdReserva()).orElse(null);
        Tipoevento tipoevento = tipoeventoRepository.findById(dto.getIdTipoevento()).orElse(null);

        if (reserva == null || tipoevento == null) {
            return ResponseEntity.badRequest().build();
        }

        Evento evento = new Evento();
        evento.setOrcamento(dto.getOrcamento());
        evento.setCronograma(dto.getCronograma());
        evento.setStatusevento(dto.getStatusevento());
        evento.setIdReserva(reserva);
        evento.setIdTipoevento(tipoevento);

        eventoService.save(evento);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEvento(@PathVariable Integer id, @RequestBody EventoDTO dto) {
        Evento evento = eventoService.findById(id);
        if (evento == null) return ResponseEntity.notFound().build();

        Reserva reserva = reservaRepository.findById(dto.getIdReserva()).orElse(null);
        Tipoevento tipoevento = tipoeventoRepository.findById(dto.getIdTipoevento()).orElse(null);

        if (reserva == null || tipoevento == null) {
            return ResponseEntity.badRequest().build();
        }

        evento.setOrcamento(dto.getOrcamento());
        evento.setCronograma(dto.getCronograma());
        evento.setStatusevento(dto.getStatusevento());
        evento.setIdReserva(reserva);
        evento.setIdTipoevento(tipoevento);

        eventoService.save(evento);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Integer id) {
        Evento evento = eventoService.findById(id);
        if (evento == null) return ResponseEntity.notFound().build();

        eventoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
