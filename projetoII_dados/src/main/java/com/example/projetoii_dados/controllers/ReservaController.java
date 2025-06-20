package com.example.projetoii_dados.controllers;

import com.example.core.models.Cliente;
import com.example.core.models.Evento;
import com.example.core.models.Reserva;
import com.example.core.repositories.ClienteRepository;
import com.example.core.repositories.ReservaRepository;
import com.example.projetoii_dados.DTOs.ReservaDTO;
import com.example.projetoii_dados.services.EventoService;
import com.example.projetoii_dados.services.ReservaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservas")
@Tag(name = "Reservas", description = "Endpoints para manipular reservas")
public class ReservaController {

    private final ReservaService reservaService;
    private final ClienteRepository clienteRepository;
    private final ReservaRepository reservaRepository;
    private final EventoService eventoService;

    public ReservaController(ReservaService reservaService,
                             ClienteRepository clienteRepository,
                             ReservaRepository reservaRepository,
                             EventoService eventoService) {
        this.reservaService = reservaService;
        this.clienteRepository = clienteRepository;
        this.reservaRepository = reservaRepository;
        this.eventoService = eventoService;
    }

    @GetMapping
    public List<ReservaDTO> getAll() {
        return reservaService.findAll().stream()
                .map(r -> new ReservaDTO(
                        r.getId(),
                        r.getNome(),
                        r.getStatus(),
                        r.getData(),
                        r.getNumeroconvidados(),
                        r.getIdCliente().getId()
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> getById(@PathVariable Integer id) {
        Reserva r = reservaService.findById(id);
        if (r == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new ReservaDTO(
                r.getId(),
                r.getNome(),
                r.getStatus(),
                r.getData(),
                r.getNumeroconvidados(),
                r.getIdCliente().getId()
        ));
    }

    @PostMapping
    public ResponseEntity<ReservaDTO> create(@RequestBody ReservaDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getIdCliente()).orElse(null);
        if (cliente == null || dto.getNumeroconvidados() > 350) {
            return ResponseEntity.badRequest().build();
        }

        // ❗ Verificação extra: não permitir duas reservas na mesma data
        if (reservaRepository.existsByData(dto.getData())) {
            return ResponseEntity.status(409).build(); // 409 Conflict
        }

        Reserva r = new Reserva();
        r.setNome(dto.getNome());
        r.setStatus("Pré-Reserva");
        r.setData(dto.getData());
        r.setNumeroconvidados(dto.getNumeroconvidados());
        r.setIdCliente(cliente);

        Reserva nova = reservaService.save(r);

        return ResponseEntity.status(201).body(new ReservaDTO(
                nova.getId(),
                nova.getNome(),
                nova.getStatus(),
                nova.getData(),
                nova.getNumeroconvidados(),
                nova.getIdCliente().getId()
        ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody ReservaDTO dto) {
        Reserva existing = reservaService.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();

        // ⚠️ Impede edição se o evento associado estiver confirmado
        Evento evento = eventoService.findByReservaId(id);
        if (evento != null && "Confirmado".equalsIgnoreCase(evento.getStatusevento())) {
            return ResponseEntity.status(403).build(); // 403 Forbidden
        }

        if (dto.getNumeroconvidados() == null || dto.getNumeroconvidados() > 350) {
            return ResponseEntity.badRequest().build();
        }

        existing.setNumeroconvidados(dto.getNumeroconvidados());
        reservaService.save(existing);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Reserva existing = reservaService.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();

        // Se houver evento Planeado para esta reserva, apaga-o primeiro
        Evento evento = eventoService.findByReservaId(id);
        if (evento != null && "Planeado".equalsIgnoreCase(evento.getStatusevento())) {
            eventoService.deleteById(evento.getId());
        }

        reservaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cliente/{id}")
    public List<ReservaDTO> getByClienteId(@PathVariable Integer id) {
        return reservaService.findByClienteId(id).stream()
                .map(r -> new ReservaDTO(
                        r.getId(),
                        r.getNome(),
                        r.getStatus(),
                        r.getData(),
                        r.getNumeroconvidados(),
                        r.getIdCliente().getId()
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("/existe-data")
    public ResponseEntity<Boolean> existeReservaNaData(@RequestParam LocalDate data) {
        boolean existe = reservaRepository.existsByData(data);
        return ResponseEntity.ok(existe);
    }
}
