package com.example.projetoii_dados.controllers;

import com.example.core.models.Tipofatura;
import com.example.projetoii_dados.services.TipofaturaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipofaturas")
@Tag(name = "TipoFaturas", description = "Endpoints para manipular tipos de fatura")
public class TipofaturaController {

    private final TipofaturaService tipofaturaService;

    public TipofaturaController(TipofaturaService tipofaturaService) {
        this.tipofaturaService = tipofaturaService;
    }

    @Operation(summary = "Listar todos os tipos de fatura",
            description = "Retorna uma lista de todos os tipos de fatura cadastrados")
    @GetMapping
    public List<Tipofatura> getAllTipoFaturas() {
        return tipofaturaService.findAll();
    }

    @Operation(summary = "Buscar tipo de fatura por ID",
            description = "Retorna um tipo de fatura específico pelo seu ID. Caso não exista, retorna 404")
    @GetMapping("/{id}")
    public ResponseEntity<Tipofatura> getTipoFaturaById(@PathVariable Long id) {
        Tipofatura tf = tipofaturaService.findById(id);
        if (tf == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tf);
    }

    @Operation(summary = "Criar novo tipo de fatura",
            description = "Cria um novo tipo de fatura no sistema e retorna o tipo criado")
    @PostMapping
    public ResponseEntity<Tipofatura> createTipoFatura(@RequestBody Tipofatura tipofatura) {
        Tipofatura novo = tipofaturaService.save(tipofatura);
        return ResponseEntity.ok(novo);
    }

    @Operation(summary = "Atualizar tipo de fatura",
            description = "Atualiza os dados de um tipo de fatura existente. Caso não exista, retorna 404")
    @PutMapping("/{id}")
    public ResponseEntity<Tipofatura> updateTipoFatura(@PathVariable Long id, @RequestBody Tipofatura tipofaturaDetails) {
        Tipofatura existing = tipofaturaService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        existing.setDesignacao(tipofaturaDetails.getDesignacao());
        Tipofatura atualizado = tipofaturaService.save(existing);
        return ResponseEntity.ok(atualizado);
    }

    @Operation(summary = "Excluir tipo de fatura",
            description = "Remove um tipo de fatura do sistema. Caso não exista, retorna 404")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoFatura(@PathVariable Long id) {
        Tipofatura existing = tipofaturaService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        tipofaturaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
