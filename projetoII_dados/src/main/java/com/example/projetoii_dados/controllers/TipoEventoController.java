package com.example.projetoii_dados.controllers;

import com.example.core.models.Tipoevento;
import com.example.projetoii_dados.services.TipoEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tipo-evento")
public class TipoEventoController {

    @Autowired
    private TipoEventoService service;

    @GetMapping
    public List<Tipoevento> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tipoevento> getById(@PathVariable Long id) {
        Tipoevento te = service.findById(id);
        if (te == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(te);
    }

    @PostMapping
    public Tipoevento create(@RequestBody Tipoevento te) {
        return service.save(te);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tipoevento> update(@PathVariable Long id, @RequestBody Tipoevento details) {
        Tipoevento existing = service.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        existing.setDesignacao(details.getDesignacao());
        Tipoevento updated = service.save(existing);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Tipoevento existing = service.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

