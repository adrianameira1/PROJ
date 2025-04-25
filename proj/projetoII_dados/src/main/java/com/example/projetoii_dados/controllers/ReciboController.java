package com.example.projetoii_dados.controllers;

import com.example.projetoii_dados.models.Recibo;
import com.example.projetoii_dados.services.ReciboService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recibos")
@Tag(name = "Recibos", description = "Endpoints para manipular recibos")
public class ReciboController {

    private final ReciboService reciboService;

    public ReciboController(ReciboService reciboService) {
        this.reciboService = reciboService;
    }

    @Operation(summary = "Listar todos os recibos",
            description = "Retorna uma lista de todos os recibos cadastrados")
    @GetMapping
    public List<Recibo> getAllRecibos() {
        return reciboService.findAll();
    }

    @Operation(summary = "Buscar recibo por ID",
            description = "Retorna um recibo específico pelo seu ID. Caso não exista, retorna 404")
    @GetMapping("/{id}")
    public ResponseEntity<Recibo> getReciboById(@PathVariable Long id) {
        Recibo recibo = reciboService.findById(id);
        if (recibo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recibo);
    }

    @Operation(summary = "Criar novo recibo",
            description = "Cria um novo recibo no sistema e retorna o recibo criado")
    @PostMapping
    public ResponseEntity<Recibo> createRecibo(@RequestBody Recibo recibo) {
        Recibo novo = reciboService.save(recibo);
        return ResponseEntity.ok(novo);
    }

    @Operation(summary = "Atualizar recibo",
            description = "Atualiza os dados de um recibo existente. Caso não exista, retorna 404")
    @PutMapping("/{id}")
    public ResponseEntity<Recibo> updateRecibo(@PathVariable Long id, @RequestBody Recibo reciboDetails) {
        Recibo existing = reciboService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        existing.setNumerorecibo(reciboDetails.getNumerorecibo());
        existing.setDescricao(reciboDetails.getDescricao());
        existing.setQuantidade(reciboDetails.getQuantidade());
        existing.setValorunitario(reciboDetails.getValorunitario());
        existing.setValortotal(reciboDetails.getValortotal());
        existing.setDataemissao(reciboDetails.getDataemissao());
        existing.setDtpagamento(reciboDetails.getDtpagamento());
        existing.setObservacoes(reciboDetails.getObservacoes());
        existing.setIdFatura(reciboDetails.getIdFatura());
        existing.setIdFornecedores(reciboDetails.getIdFornecedores());
        existing.setIdMetodo(reciboDetails.getIdMetodo());

        Recibo atualizado = reciboService.save(existing);
        return ResponseEntity.ok(atualizado);
    }

    @Operation(summary = "Excluir recibo",
            description = "Remove um recibo do sistema. Caso não exista, retorna 404")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecibo(@PathVariable Long id) {
        Recibo existing = reciboService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        reciboService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
