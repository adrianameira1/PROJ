package com.example.projetoii_dados.controllers;

import com.example.core.models.Cliente;
import com.example.core.models.Reserva;
import com.example.core.repositories.ClienteRepository;
import com.example.projetoii_dados.DTOs.ReservaDTO;
import com.example.projetoii_dados.services.ReservaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservas")
@Tag(name = "Reservas", description = "Endpoints para manipular reservas")
public class ReservaController {

    private final ReservaService reservaService;
    private final ClienteRepository clienteRepository;

    public ReservaController(ReservaService reservaService, ClienteRepository clienteRepository) {
        this.reservaService = reservaService;
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<ReservaDTO> getAll() {
        return reservaService.findAll().stream()
                .map(r -> new ReservaDTO(
                        r.getNome(),
                        r.getStatus(),
                        r.getData(),
                        r.getNumeroconvidados(),
                        r.getIdCliente().getId()
                )).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> getById(@PathVariable Integer id) {
        Reserva r = reservaService.findById(id);
        if (r == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new ReservaDTO(
                r.getNome(),
                r.getStatus(),
                r.getData(),
                r.getNumeroconvidados(),
                r.getIdCliente().getId()
        ));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ReservaDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getIdCliente()).orElse(null);
        if (cliente == null) return ResponseEntity.badRequest().build();

        Reserva r = new Reserva();
        r.setNome(dto.getNome());
        r.setStatus(dto.getStatus());
        r.setData(dto.getData());
        r.setNumeroconvidados(dto.getNumeroconvidados());
        r.setIdCliente(cliente);

        reservaService.save(r);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody ReservaDTO dto) {
        Reserva existing = reservaService.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();

        Cliente cliente = clienteRepository.findById(dto.getIdCliente()).orElse(null);
        if (cliente == null) return ResponseEntity.badRequest().build();

        existing.setNome(dto.getNome());
        existing.setStatus(dto.getStatus());
        existing.setData(dto.getData());
        existing.setNumeroconvidados(dto.getNumeroconvidados());
        existing.setIdCliente(cliente);

        reservaService.save(existing);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Reserva existing = reservaService.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();

        reservaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
