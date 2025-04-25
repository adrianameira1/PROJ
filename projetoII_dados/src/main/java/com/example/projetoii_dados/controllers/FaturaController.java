package com.example.projetoii_dados.controllers;

import com.example.projetoii_dados.models.Fatura;
import com.example.projetoii_dados.services.FaturaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faturas")
@Tag(name = "Faturas", description = "Endpoints para manipular faturas")
public class FaturaController {

    private final FaturaService faturaService;

    public FaturaController(FaturaService faturaService) {
        this.faturaService = faturaService;
    }

    @Operation(summary = "Listar todas as faturas",
            description = "Retorna uma lista de todas as faturas cadastradas")
    @GetMapping
    public List<Fatura> getAllFaturas() {
        return faturaService.findAll();
    }

    @Operation(summary = "Buscar fatura por ID",
            description = "Retorna uma fatura específica pelo seu ID. Caso não exista, retorna 404")
    @GetMapping("/{id}")
    public ResponseEntity<Fatura> getFaturaById(@PathVariable Long id) {
        Fatura fatura = faturaService.findById(id);
        if (fatura == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fatura);
    }

    @Operation(summary = "Criar nova fatura",
            description = "Cria uma nova fatura no sistema e retorna a fatura criada")
    @PostMapping
    public ResponseEntity<Fatura> createFatura(@RequestBody Fatura fatura) {
        Fatura nova = faturaService.save(fatura);
        return ResponseEntity.ok(nova);
    }

    @Operation(summary = "Atualizar fatura",
            description = "Atualiza os dados de uma fatura existente. Caso não exista, retorna 404")
    @PutMapping("/{id}")
    public ResponseEntity<Fatura> updateFatura(@PathVariable Long id, @RequestBody Fatura faturaDetails) {
        Fatura existing = faturaService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        existing.setValor(faturaDetails.getValor());
        existing.setDtemissao(faturaDetails.getDtemissao());
        existing.setStatus(faturaDetails.getStatus());
        existing.setDtpagamento(faturaDetails.getDtpagamento());
        existing.setIdEvento(faturaDetails.getIdEvento());
        existing.setIdTipofatura(faturaDetails.getIdTipofatura());

        Fatura atualizada = faturaService.save(existing);
        return ResponseEntity.ok(atualizada);
    }

    @Operation(summary = "Excluir fatura",
            description = "Remove uma fatura do sistema. Caso não exista, retorna 404")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFatura(@PathVariable Long id) {
        Fatura existing = faturaService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        faturaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
