package com.example.projetoii_dados.controllers;

import com.example.core.models.Reserva;
import com.example.projetoii_dados.services.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@Tag(name = "Reservas", description = "Endpoints para manipular reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @Operation(summary = "Listar todas as reservas",
            description = "Retorna uma lista de todas as reservas cadastradas")
    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaService.findAll();
    }

    @Operation(summary = "Buscar reserva por ID",
            description = "Retorna uma reserva específica pelo seu ID. Caso não exista, retorna 404")
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable Integer id) {
        Reserva reserva = reservaService.findById(id);
        if (reserva == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reserva);
    }

    @Operation(summary = "Criar nova reserva",
            description = "Cria uma nova reserva e retorna a reserva criada")
    @PostMapping
    public ResponseEntity<Reserva> createReserva(@RequestBody Reserva reserva) {
        Reserva nova = reservaService.save(reserva);
        return ResponseEntity.ok(nova);
    }

    @Operation(summary = "Atualizar reserva",
            description = "Atualiza os dados de uma reserva existente. Caso não exista, retorna 404")
    @PutMapping("/{id}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable Integer id, @RequestBody Reserva reservaDetails) {
        Reserva existing = reservaService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        // Exemplo de atualização:
        existing.setNome(reservaDetails.getNome());
        existing.setStatus(reservaDetails.getStatus());
        existing.setData(reservaDetails.getData());
        existing.setNumeroconvidados(reservaDetails.getNumeroconvidados());
        existing.setIdCliente(reservaDetails.getIdCliente());

        Reserva atualizada = reservaService.save(existing);
        return ResponseEntity.ok(atualizada);
    }

    @Operation(summary = "Excluir reserva",
            description = "Remove uma reserva do sistema. Caso não exista, retorna 404")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Integer id) {
        Reserva existing = reservaService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        reservaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
