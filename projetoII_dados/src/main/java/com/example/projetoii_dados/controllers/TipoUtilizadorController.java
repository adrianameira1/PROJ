package com.example.projetoii_dados.controllers;

import com.example.core.models.Tipoutilizador;
import com.example.projetoii_dados.services.TipoUtilizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tipo-utilizador")
public class TipoUtilizadorController {

    @Autowired
    private TipoUtilizadorService service;

    @GetMapping
    public List<Tipoutilizador> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tipoutilizador> getById(@PathVariable Long id) {
        Tipoutilizador tu = service.findById(id);
        if (tu == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tu);
    }

    @PostMapping
    public Tipoutilizador create(@RequestBody Tipoutilizador tu) {
        return service.save(tu);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tipoutilizador> update(@PathVariable Long id, @RequestBody Tipoutilizador details) {
        Tipoutilizador existing = service.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        existing.setDesignacao(details.getDesignacao());
        Tipoutilizador updated = service.save(existing);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Tipoutilizador existing = service.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

