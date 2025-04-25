package com.example.projetoii_dados.controllers;

import com.example.projetoii_dados.models.Funcaofuncionario;
import com.example.projetoii_dados.services.FuncaoFuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcao-funcionario")
public class FuncaoFuncionarioController {

    @Autowired
    private FuncaoFuncionarioService service;

    @GetMapping
    public List<Funcaofuncionario> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcaofuncionario> getById(@PathVariable Long id) {
        Funcaofuncionario ff = service.findById(id);
        if (ff == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ff);
    }

    @PostMapping
    public Funcaofuncionario create(@RequestBody Funcaofuncionario ff) {
        return service.save(ff);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcaofuncionario> update(@PathVariable Long id,
                                                    @RequestBody Funcaofuncionario ffDetails) {
        Funcaofuncionario existing = service.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        existing.setDesignacao(ffDetails.getDesignacao());
        Funcaofuncionario updated = service.save(existing);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Funcaofuncionario existing = service.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

