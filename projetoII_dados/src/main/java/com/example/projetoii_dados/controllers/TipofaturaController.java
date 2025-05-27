package com.example.projetoii_dados.controllers;

import com.example.core.models.Tipofatura;
import com.example.projetoii_dados.DTOs.TipoFaturaDTO;
import com.example.projetoii_dados.services.TipofaturaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tipofaturas")
@Tag(name = "Tipo de Fatura", description = "Endpoints para manipular tipos de fatura")
public class TipofaturaController {

    private final TipofaturaService service;

    public TipofaturaController(TipofaturaService service) {
        this.service = service;
    }

    @GetMapping
    public List<TipoFaturaDTO> getAll() {
        return service.findAll().stream()
                .map(t -> new TipoFaturaDTO(t.getDesignacao()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoFaturaDTO> getById(@PathVariable Integer id) {
        Tipofatura t = service.findById(id);
        if (t == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new TipoFaturaDTO(t.getDesignacao()));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody TipoFaturaDTO dto) {
        Tipofatura t = new Tipofatura();
        t.setDesignacao(dto.getDesignacao());
        service.save(t);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody TipoFaturaDTO dto) {
        Tipofatura existing = service.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();
        existing.setDesignacao(dto.getDesignacao());
        service.save(existing);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Tipofatura existing = service.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
