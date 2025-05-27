package com.example.projetoii_dados.controllers;

import com.example.core.models.Cliente;
import com.example.projetoii_dados.DTOs.ClienteDTO;
import com.example.projetoii_dados.services.ClienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Clientes", description = "Endpoints para manipular clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<ClienteDTO> getAllClientes() {
        return clienteService.findAll().stream()
                .map(c -> new ClienteDTO(c.getNome(), c.getEmail(), c.getTelefone()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Integer id) {
        Cliente cliente = clienteService.findById(id);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        ClienteDTO dto = new ClienteDTO(cliente.getNome(), cliente.getEmail(), cliente.getTelefone());
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<Void> createCliente(@RequestBody ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());
        clienteService.save(cliente);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCliente(@PathVariable Integer id, @RequestBody ClienteDTO dto) {
        Cliente existing = clienteService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        existing.setNome(dto.getNome());
        existing.setEmail(dto.getEmail());
        existing.setTelefone(dto.getTelefone());
        clienteService.save(existing);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Integer id) {
        Cliente existing = clienteService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
