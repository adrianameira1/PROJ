package com.example.projetoii_dados.controllers;

import com.example.projetoii_dados.models.Cliente;
import com.example.projetoii_dados.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")  // URL base para "Cliente"
@Tag(name = "Clientes", description = "Endpoints para manipular clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Operation(summary = "Listar todos os clientes",
            description = "Retorna uma lista de todos os clientes cadastrados")
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.findAll();
    }

    @Operation(summary = "Buscar cliente por ID",
            description = "Retorna um cliente específico pelo seu ID. Caso não exista, retorna 404")
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Cliente cliente = clienteService.findById(id);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @Operation(summary = "Criar novo cliente",
            description = "Cria um novo cliente no sistema e retorna o cliente criado")
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente novo = clienteService.save(cliente);
        return ResponseEntity.ok(novo);
    }

    @Operation(summary = "Atualizar cliente",
            description = "Atualiza os dados de um cliente existente pelo ID. Caso não exista, retorna 404")
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteDetails) {
        Cliente existing = clienteService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        existing.setNome(clienteDetails.getNome());
        existing.setEmail(clienteDetails.getEmail());
        existing.setTelefone(clienteDetails.getTelefone());

        Cliente atualizado = clienteService.save(existing);
        return ResponseEntity.ok(atualizado);
    }

    @Operation(summary = "Excluir cliente",
            description = "Remove um cliente do sistema pelo ID. Caso não exista, retorna 404")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        Cliente existing = clienteService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
