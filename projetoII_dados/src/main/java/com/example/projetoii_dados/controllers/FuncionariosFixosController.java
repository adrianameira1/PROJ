package com.example.projetoii_dados.controllers;

import com.example.core.models.Funcionariosfixo;
import com.example.projetoii_dados.services.FuncionariosFixosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios-fixos")
public class FuncionariosFixosController {

    @Autowired
    private FuncionariosFixosService service;

    // GET /funcionarios-fixos
    @GetMapping
    public List<Funcionariosfixo> getAll() {
        return service.findAll();
    }

    // GET /funcionarios-fixos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Funcionariosfixo> getById(@PathVariable Long id) {
        Funcionariosfixo ff = service.findById(id);
        if (ff == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ff);
    }

    // POST /funcionarios-fixos
    @PostMapping
    public Funcionariosfixo create(@RequestBody Funcionariosfixo ff) {
        return service.save(ff);
    }

    // PUT /funcionarios-fixos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Funcionariosfixo> update(@PathVariable Long id,
                                                    @RequestBody Funcionariosfixo ffDetails) {
        Funcionariosfixo existing = service.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        existing.setNome(ffDetails.getNome());
        existing.setIdFuncao(ffDetails.getIdFuncao());
        Funcionariosfixo updated = service.save(existing);
        return ResponseEntity.ok(updated);
    }


    // DELETE /funcionarios-fixos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Funcionariosfixo existing = service.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

