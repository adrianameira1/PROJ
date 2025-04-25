package com.example.projetoii_dados.controllers;

import com.example.projetoii_dados.models.Servico;
import com.example.projetoii_dados.services.ServicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
@Tag(name = "Serviços", description = "Endpoints para manipular serviços")
public class ServicoController {

    private final ServicoService servicoService;

    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @Operation(summary = "Listar todos os serviços",
            description = "Retorna uma lista de todos os serviços cadastrados")
    @GetMapping
    public List<Servico> getAllServicos() {
        return servicoService.findAll();
    }

    @Operation(summary = "Buscar serviço por ID",
            description = "Retorna um serviço específico pelo seu ID. Caso não exista, retorna 404")
    @GetMapping("/{id}")
    public ResponseEntity<Servico> getServicoById(@PathVariable Long id) {
        Servico servico = servicoService.findById(id);
        if (servico == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(servico);
    }

    @Operation(summary = "Criar novo serviço",
            description = "Cria um novo serviço no sistema e retorna o serviço criado")
    @PostMapping
    public ResponseEntity<Servico> createServico(@RequestBody Servico servico) {
        Servico novo = servicoService.save(servico);
        return ResponseEntity.ok(novo);
    }

    @Operation(summary = "Atualizar serviço",
            description = "Atualiza os dados de um serviço existente. Caso não exista, retorna 404")
    @PutMapping("/{id}")
    public ResponseEntity<Servico> updateServico(@PathVariable Long id, @RequestBody Servico servicoDetails) {
        Servico existing = servicoService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        existing.setStatuspagamento(servicoDetails.getStatuspagamento());
        existing.setDetalhesservico(servicoDetails.getDetalhesservico());
        existing.setCustototal(servicoDetails.getCustototal());
        existing.setIdEvento(servicoDetails.getIdEvento());
        existing.setIdTiposervico(servicoDetails.getIdTiposervico());

        Servico atualizado = servicoService.save(existing);
        return ResponseEntity.ok(atualizado);
    }

    @Operation(summary = "Excluir serviço",
            description = "Remove um serviço do sistema. Caso não exista, retorna 404")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServico(@PathVariable Long id) {
        Servico existing = servicoService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        servicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
