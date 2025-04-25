package com.example.projetoii_dados.controllers;

import com.example.projetoii_dados.models.Tiposervico;
import com.example.projetoii_dados.services.TipoEventoService;
import com.example.projetoii_dados.services.TipoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tipo-servico")
public class TipoServicoController {

    @Autowired
    private TipoServicoService service;

    @GetMapping
    public List<Tiposervico> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tiposervico> getById(@PathVariable Long id) {
        Tiposervico te = service.findById(id);
        if (te == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(te);
    }

    @PostMapping
    public Tiposervico create(@RequestBody Tiposervico te) {
        return service.save(te);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tiposervico> update(@PathVariable Long id, @RequestBody Tiposervico details) {
        Tiposervico existing = service.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        existing.setDesignacao(details.getDesignacao());
        Tiposervico updated = service.save(existing);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Tiposervico existing = service.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


