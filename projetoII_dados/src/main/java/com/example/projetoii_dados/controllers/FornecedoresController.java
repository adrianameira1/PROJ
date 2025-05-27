package com.example.projetoii_dados.controllers;

import com.example.core.models.Fornecedor;
import com.example.projetoii_dados.DTOs.FornecedorDTO;
import com.example.projetoii_dados.services.FornecedoresService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/fornecedores")
@Tag(name = "Fornecedores", description = "Endpoints para manipular fornecedores")
public class FornecedoresController {

    private final FornecedoresService fornecedorService;

    public FornecedoresController(FornecedoresService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @GetMapping
    public List<FornecedorDTO> getAll() {
        return fornecedorService.findAll().stream()
                .map(f -> new FornecedorDTO(f.getNome(), f.getContacto()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorDTO> getById(@PathVariable Integer id) {
        Fornecedor f = fornecedorService.findById(id);
        if (f == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new FornecedorDTO(f.getNome(), f.getContacto()));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody FornecedorDTO dto) {
        Fornecedor f = new Fornecedor();
        f.setNome(dto.getNome());
        f.setContacto(dto.getContacto());
        fornecedorService.save(f);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody FornecedorDTO dto) {
        Fornecedor existing = fornecedorService.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();

        existing.setNome(dto.getNome());
        existing.setContacto(dto.getContacto());
        fornecedorService.save(existing);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Fornecedor existing = fornecedorService.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();

        fornecedorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
