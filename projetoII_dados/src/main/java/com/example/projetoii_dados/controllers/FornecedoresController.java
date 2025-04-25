package com.example.projetoii_dados.controllers;

import com.example.projetoii_dados.models.Fornecedore;
import com.example.projetoii_dados.services.FornecedoresService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fornecedores")
@Tag(name = "Fornecedores", description = "Endpoints para manipular fornecedores")
public class FornecedoresController {

    private final FornecedoresService fornecedoresService;

    public FornecedoresController(FornecedoresService fornecedoresService) {
        this.fornecedoresService = fornecedoresService;
    }

    @Operation(summary = "Listar todos os fornecedores",
            description = "Retorna uma lista de todos os fornecedores cadastrados")
    @GetMapping
    public List<Fornecedore> getAllFornecedores() {
        return fornecedoresService.findAll();
    }

    @Operation(summary = "Buscar fornecedor por ID",
            description = "Retorna um fornecedor específico pelo seu ID. Caso não exista, retorna 404")
    @GetMapping("/{id}")
    public ResponseEntity<Fornecedore> getFornecedoresById(@PathVariable Long id) {
        Fornecedore fornecedor = fornecedoresService.findById(id);
        if (fornecedor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fornecedor);
    }

    @Operation(summary = "Criar novo fornecedor",
            description = "Cria um novo fornecedor no sistema e retorna o fornecedor criado")
    @PostMapping
    public ResponseEntity<Fornecedore> createFornecedor(@RequestBody Fornecedore fornecedor) {
        Fornecedore novo = fornecedoresService.save(fornecedor);
        return ResponseEntity.ok(novo);
    }

    @Operation(summary = "Atualizar fornecedor",
            description = "Atualiza os dados de um fornecedor existente. Caso não exista, retorna 404")
    @PutMapping("/{id}")
    public ResponseEntity<Fornecedore> updateFornecedor(@PathVariable Long id,
                                                         @RequestBody Fornecedore fornecedorDetails) {
        Fornecedore existing = fornecedoresService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        existing.setNome(fornecedorDetails.getNome());
        existing.setContacto(fornecedorDetails.getContacto());

        Fornecedore atualizado = fornecedoresService.save(existing);
        return ResponseEntity.ok(atualizado);
    }

    @Operation(summary = "Excluir fornecedor",
            description = "Remove um fornecedor do sistema. Caso não exista, retorna 404")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFornecedor(@PathVariable Long id) {
        Fornecedore existing = fornecedoresService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        fornecedoresService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
