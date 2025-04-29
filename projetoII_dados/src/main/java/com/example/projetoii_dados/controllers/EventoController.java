package com.example.projetoii_dados.controllers;

import com.example.core.models.Evento;
import com.example.projetoii_dados.services.EventoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@Tag(name = "Eventos", description = "Endpoints para manipular eventos")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @Operation(summary = "Listar todos os eventos",
            description = "Retorna uma lista de todos os eventos cadastrados")
    @GetMapping
    public List<Evento> getAllEventos() {
        return eventoService.findAll();
    }

    @Operation(summary = "Buscar evento por ID",
            description = "Retorna um evento específico pelo seu ID. Caso não exista, retorna 404")
    @GetMapping("/{id}")
    public ResponseEntity<Evento> getEventoById(@PathVariable Long id) {
        Evento evento = eventoService.findById(id);
        if (evento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(evento);
    }

    @Operation(summary = "Criar novo evento",
            description = "Cria um novo evento no sistema e retorna o evento criado")
    @PostMapping
    public ResponseEntity<Evento> createEvento(@RequestBody Evento evento) {
        Evento novo = eventoService.save(evento);
        return ResponseEntity.ok(novo);
    }

    @Operation(summary = "Atualizar evento",
            description = "Atualiza os dados de um evento existente. Caso não exista, retorna 404")
    @PutMapping("/{id}")
    public ResponseEntity<Evento> updateEvento(@PathVariable Long id, @RequestBody Evento eventoDetails) {
        Evento existing = eventoService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        // Exemplo de atualização de campos (ajuste conforme seu model):
        existing.setOrcamento(eventoDetails.getOrcamento());
        existing.setCronograma(eventoDetails.getCronograma());
        existing.setStatusevento(eventoDetails.getStatusevento());
        existing.setIdReserva(eventoDetails.getIdReserva());
        existing.setIdTipoevento(eventoDetails.getIdTipoevento());

        Evento atualizado = eventoService.save(existing);
        return ResponseEntity.ok(atualizado);
    }

    @Operation(summary = "Excluir evento",
            description = "Remove um evento do sistema. Caso não exista, retorna 404")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Long id) {
        Evento existing = eventoService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        eventoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
