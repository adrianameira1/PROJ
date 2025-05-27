package com.example.projetoii_dados.controllers;

import com.example.core.models.Tiposervico;
import com.example.projetoii_dados.DTOs.TipoServicoDTO;
import com.example.projetoii_dados.services.TipoServicoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tiposervicos")
@Tag(name = "Tipo de Serviço", description = "Endpoints para manipular tipos de serviço")
public class TipoServicoController {

    private final TipoServicoService service;

    public TipoServicoController(TipoServicoService service) {
        this.service = service;
    }

    @GetMapping
    public List<TipoServicoDTO> getAll() {
        return service.findAll().stream()
                .map(t -> new TipoServicoDTO(t.getDesignacao()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoServicoDTO> getById(@PathVariable Integer id) {
        Tiposervico t = service.findById(id);
        if (t == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new TipoServicoDTO(t.getDesignacao()));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody TipoServicoDTO dto) {
        Tiposervico t = new Tiposervico();
        t.setDesignacao(dto.getDesignacao());
        service.save(t);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody TipoServicoDTO dto) {
        Tiposervico existing = service.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();
        existing.setDesignacao(dto.getDesignacao());
        service.save(existing);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Tiposervico existing = service.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
