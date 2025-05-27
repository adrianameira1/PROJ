package com.example.projetoii_dados.controllers;

import com.example.core.models.Eventofuncionario;
import com.example.core.models.EventofuncionarioId;
import com.example.projetoii_dados.dtos.EventoFuncionarioDTO;
import com.example.projetoii_dados.services.EventoFuncionarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/evento-funcionario")
@Tag(name = "EventoFuncionario", description = "Associação entre Evento e Funcionário Fixo")
public class EventoFuncionarioController {

    private final EventoFuncionarioService eventoFuncionarioService;

    public EventoFuncionarioController(EventoFuncionarioService eventoFuncionarioService) {
        this.eventoFuncionarioService = eventoFuncionarioService;
    }

    @GetMapping
    public List<EventoFuncionarioDTO> getAll() {
        return eventoFuncionarioService.findAll().stream()
                .map(ef -> new EventoFuncionarioDTO(ef.getIdEvento(), ef.getIdFuncionario()))
                .collect(Collectors.toList());
    }

    @GetMapping("/evento/{eventoId}/funcionario/{funcionarioId}")
    public ResponseEntity<EventoFuncionarioDTO> getById(@PathVariable Integer eventoId, @PathVariable Integer funcionarioId) {
        Eventofuncionario ef = eventoFuncionarioService.findById(new EventofuncionarioId(eventoId, funcionarioId));
        if (ef == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new EventoFuncionarioDTO(ef.getIdEvento(), ef.getIdFuncionario()));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody EventoFuncionarioDTO dto) {
        Eventofuncionario ef = new Eventofuncionario(dto.getIdEvento(), dto.getIdFuncionario());
        eventoFuncionarioService.save(ef);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/evento/{eventoId}/funcionario/{funcionarioId}")
    public ResponseEntity<Void> delete(@PathVariable Integer eventoId, @PathVariable Integer funcionarioId) {
        Eventofuncionario ef = eventoFuncionarioService.findById(new EventofuncionarioId(eventoId, funcionarioId));
        if (ef == null) return ResponseEntity.notFound().build();
        eventoFuncionarioService.deleteById(new EventofuncionarioId(eventoId, funcionarioId));
        return ResponseEntity.noContent().build();
    }
}
