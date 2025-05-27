package com.example.projetoii_dados.controllers;

import com.example.core.models.Tipoutilizador;
import com.example.projetoii_dados.DTOs.TipoUtilizadorDTO;
import com.example.projetoii_dados.services.TipoUtilizadorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tipoutilizadores")
@Tag(name = "Tipo de Utilizador", description = "Endpoints para manipular tipos de utilizador")
public class TipoUtilizadorController {

    private final TipoUtilizadorService service;

    public TipoUtilizadorController(TipoUtilizadorService service) {
        this.service = service;
    }

    @GetMapping
    public List<TipoUtilizadorDTO> getAll() {
        return service.findAll().stream()
                .map(t -> new TipoUtilizadorDTO(t.getDesignacao()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoUtilizadorDTO> getById(@PathVariable Integer id) {
        Tipoutilizador t = service.findById(id);
        if (t == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new TipoUtilizadorDTO(t.getDesignacao()));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody TipoUtilizadorDTO dto) {
        Tipoutilizador t = new Tipoutilizador();
        t.setDesignacao(dto.getDesignacao());
        service.save(t);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody TipoUtilizadorDTO dto) {
        Tipoutilizador existing = service.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();
        existing.setDesignacao(dto.getDesignacao());
        service.save(existing);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Tipoutilizador existing = service.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
