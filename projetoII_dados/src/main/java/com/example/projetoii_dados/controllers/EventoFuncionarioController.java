package com.example.projetoii_dados.controllers;

import com.example.core.models.Eventofuncionario;
import com.example.core.models.EventofuncionarioId;
import com.example.projetoii_dados.services.EventoFuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evento-funcionario")
@Tag(name = "EventoFuncionario", description = "Endpoints para associação de Evento e Funcionários (N:N)")
public class EventoFuncionarioController {

    private final EventoFuncionarioService eventoFuncionarioService;

    public EventoFuncionarioController(EventoFuncionarioService eventoFuncionarioService) {
        this.eventoFuncionarioService = eventoFuncionarioService;
    }

    @Operation(summary = "Listar todas as associações Evento-Funcionário",
            description = "Retorna a lista de todas as relações entre eventos e funcionários fixos")
    @GetMapping
    public List<Eventofuncionario> getAll() {
        return eventoFuncionarioService.findAll();
    }

    @Operation(summary = "Buscar associação por ID composto",
            description = "Retorna a associação especificada pelos IDs (Evento, Funcionário). Caso não exista, retorna 404")
    @GetMapping("/evento/{eventoId}/funcionario/{funcionarioId}")
    public ResponseEntity<Eventofuncionario> getById(
            @PathVariable Integer eventoId,
            @PathVariable Integer funcionarioId
    ) {
        EventofuncionarioId efId = new EventofuncionarioId(eventoId, funcionarioId);
        Eventofuncionario ef = eventoFuncionarioService.findById(efId);
        if (ef == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ef);
    }

    @Operation(summary = "Criar nova associação Evento-Funcionário",
            description = "Cria uma nova relação entre um evento e um funcionário fixo")
    @PostMapping
    public ResponseEntity<Eventofuncionario> create(@RequestBody Eventofuncionario ef) {
        // Supondo que o body traga o 'id' ou as referências de 'evento' e 'funcionario'.
        Eventofuncionario novo = eventoFuncionarioService.save(ef);
        return ResponseEntity.ok(novo);
    }

    @Operation(summary = "Excluir associação Evento-Funcionário",
            description = "Remove a associação pelo ID composto (evento e funcionário). Caso não exista, retorna 404")
    @DeleteMapping("/evento/{eventoId}/funcionario/{funcionarioId}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer eventoId,
            @PathVariable Integer funcionarioId
    ) {
        EventofuncionarioId efId = new EventofuncionarioId(eventoId, funcionarioId);
        Eventofuncionario existing = eventoFuncionarioService.findById(efId);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        eventoFuncionarioService.deleteById(efId);
        return ResponseEntity.noContent().build();
    }
}
