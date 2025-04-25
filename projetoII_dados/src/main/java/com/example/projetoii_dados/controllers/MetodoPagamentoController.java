package com.example.projetoii_dados.controllers;

import com.example.projetoii_dados.models.Metodopagamento;
import com.example.projetoii_dados.services.MetodoPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/metodo-pagamento")
public class MetodoPagamentoController {

    @Autowired
    private MetodoPagamentoService service;

    @GetMapping
    public List<Metodopagamento> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Metodopagamento> getById(@PathVariable Long id) {
        Metodopagamento mp = service.findById(id);
        if (mp == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mp);
    }

    @PostMapping
    public Metodopagamento create(@RequestBody Metodopagamento mp) {
        return service.save(mp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Metodopagamento> update(@PathVariable Long id, @RequestBody Metodopagamento details) {
        Metodopagamento existing = service.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        existing.setDesignacao(details.getDesignacao());
        Metodopagamento updated = service.save(existing);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Metodopagamento existing = service.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
