package com.example.projetoii_dados.controllers;

import com.example.projetoii_dados.models.ServicoFornecedor;
import com.example.projetoii_dados.models.ServicoFornecedorId;
import com.example.projetoii_dados.services.ServicoFornecedorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servico-fornecedor")
@Tag(name = "ServicoFornecedor", description = "Endpoints para manipular a associação de Servico e Fornecedor (N:N)")
public class ServicoFornecedorController {

    private final ServicoFornecedorService servicoFornecedorService;

    public ServicoFornecedorController(ServicoFornecedorService servicoFornecedorService) {
        this.servicoFornecedorService = servicoFornecedorService;
    }

    @Operation(summary = "Listar todas as associações Servico-Fornecedor",
            description = "Retorna a lista de todas as relações entre serviços e fornecedores")
    @GetMapping
    public List<ServicoFornecedor> getAll() {
        return servicoFornecedorService.findAll();
    }

    @Operation(summary = "Buscar associação por ID composto",
            description = "Retorna a associação especificada pelos IDs de fornecedor e serviço. Caso não exista, retorna 404")
    @GetMapping("/fornecedor/{fornecedorId}/servico/{servicoId}")
    public ResponseEntity<ServicoFornecedor> getById(
            @PathVariable Integer fornecedorId,
            @PathVariable Integer servicoId
    ) {
        ServicoFornecedorId sfId = new ServicoFornecedorId(fornecedorId, servicoId);
        ServicoFornecedor sf = servicoFornecedorService.findById(sfId);
        if (sf == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sf);
    }

    @Operation(summary = "Criar nova associação Servico-Fornecedor",
            description = "Cria uma nova relação entre um serviço e um fornecedor")
    @PostMapping
    public ResponseEntity<ServicoFornecedor> create(@RequestBody ServicoFornecedor sf) {
        // Aqui assumimos que o body já traga: id (com os IDs), ou o servico e fornecedor
        // Necessário ter cuidado pois pode ser que você precise setar o ServicoFornecedorId manualmente
        ServicoFornecedor novo = servicoFornecedorService.save(sf);
        return ResponseEntity.ok(novo);
    }

    @Operation(summary = "Excluir associação Servico-Fornecedor",
            description = "Remove uma associação pelo ID composto. Caso não exista, retorna 404")
    @DeleteMapping("/fornecedor/{fornecedorId}/servico/{servicoId}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer fornecedorId,
            @PathVariable Integer servicoId
    ) {
        ServicoFornecedorId sfId = new ServicoFornecedorId(fornecedorId, servicoId);
        ServicoFornecedor existing = servicoFornecedorService.findById(sfId);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        servicoFornecedorService.deleteById(sfId);
        return ResponseEntity.noContent().build();
    }
}
