package com.example.projetoii_dados.controllers;

import com.example.core.models.Tipoevento;
import com.example.projetoii_dados.DTOs.TipoEventoDTO;
import com.example.projetoii_dados.services.TipoEventoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tipoeventos")
@Tag(name = "Tipo de Evento", description = "Endpoints para manipular tipos de evento")
public class TipoEventoController {

    private final TipoEventoService service;

    public TipoEventoController(TipoEventoService service) {
        this.service = service;
    }

    @GetMapping
    public List<TipoEventoDTO> getAll() {
        return service.findAll().stream()
                .map(t -> new TipoEventoDTO(t.getDesignacao()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoEventoDTO> getById(@PathVariable Integer id) {
        Tipoevento t = service.findById(id);
        if (t == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new TipoEventoDTO(t.getDesignacao()));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody TipoEventoDTO dto) {
        Tipoevento t = new Tipoevento();
        t.setDesignacao(dto.getDesignacao());
        service.save(t);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody TipoEventoDTO dto) {
        Tipoevento existing = service.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();
        existing.setDesignacao(dto.getDesignacao());
        service.save(existing);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Tipoevento existing = service.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
