package com.example.projetoii_dados.controllers;

import com.example.core.models.Metodopagamento;
import com.example.projetoii_dados.DTOs.MetodoPagamentoDTO;
import com.example.projetoii_dados.services.MetodoPagamentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/metodos-pagamento")
@Tag(name = "Métodos de Pagamento", description = "Endpoints para manipular métodos de pagamento")
public class MetodoPagamentoController {

    private final MetodoPagamentoService metodoPagamentoService;

    public MetodoPagamentoController(MetodoPagamentoService metodoPagamentoService) {
        this.metodoPagamentoService = metodoPagamentoService;
    }

    @GetMapping
    public List<MetodoPagamentoDTO> getAll() {
        return metodoPagamentoService.findAll().stream()
                .map(m -> new MetodoPagamentoDTO(m.getDesignacao()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoPagamentoDTO> getById(@PathVariable Integer id) {
        Metodopagamento m = metodoPagamentoService.findById(id);
        if (m == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new MetodoPagamentoDTO(m.getDesignacao()));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody MetodoPagamentoDTO dto) {
        Metodopagamento m = new Metodopagamento();
        m.setDesignacao(dto.getDesignacao());
        metodoPagamentoService.save(m);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody MetodoPagamentoDTO dto) {
        Metodopagamento existing = metodoPagamentoService.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();

        existing.setDesignacao(dto.getDesignacao());
        metodoPagamentoService.save(existing);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Metodopagamento existing = metodoPagamentoService.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();

        metodoPagamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}