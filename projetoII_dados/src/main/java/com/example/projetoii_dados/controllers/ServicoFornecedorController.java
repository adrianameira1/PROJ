package com.example.projetoii_dados.controllers;

import com.example.core.models.Fornecedor;
import com.example.core.models.Servico;
import com.example.core.models.ServicoFornecedor;
import com.example.core.models.ServicoFornecedorId;
import com.example.core.repositories.FornecedorRepository;
import com.example.core.repositories.ServicoRepository;
import com.example.projetoii_dados.DTOs.ServicoFornecedorDTO;
import com.example.projetoii_dados.services.ServicoFornecedorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/servico-fornecedores")
@Tag(name = "Serviço-Fornecedor", description = "Relacionamento entre serviços e fornecedores")
public class ServicoFornecedorController {

    private final ServicoFornecedorService service;
    private final ServicoRepository servicoRepository;
    private final FornecedorRepository fornecedoreRepository;

    public ServicoFornecedorController(ServicoFornecedorService service,
                                       ServicoRepository servicoRepository,
                                       FornecedorRepository fornecedoreRepository) {
        this.service = service;
        this.servicoRepository = servicoRepository;
        this.fornecedoreRepository = fornecedoreRepository;
    }

    @GetMapping
    public List<ServicoFornecedorDTO> getAll() {
        return service.findAll().stream()
                .map(sf -> new ServicoFornecedorDTO(
                        sf.getId().getIdServico(),
                        sf.getId().getIdFornecedor()
                )).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ServicoFornecedorDTO dto) {
        Servico servico = servicoRepository.findById(dto.getIdServico().intValue()).orElse(null);
        Fornecedor fornecedor = fornecedoreRepository.findById(dto.getIdFornecedor().intValue()).orElse(null);
        if (servico == null || fornecedor == null) return ResponseEntity.badRequest().build();

        ServicoFornecedor relacao = new ServicoFornecedor();
        relacao.setId(new ServicoFornecedorId(
                dto.getIdServico().intValue(),
                dto.getIdFornecedor().intValue()
        ));
        relacao.setIdServico(servico);
        relacao.setIdFornecedor(fornecedor);

        service.save(relacao);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{idServico}/{idFornecedor}")
    public ResponseEntity<Void> delete(@PathVariable Integer idServico, @PathVariable Integer idFornecedor) {
        ServicoFornecedorId id = new ServicoFornecedorId(idServico, idFornecedor);
        ServicoFornecedor relacao = service.findById(id);
        if (relacao == null) return ResponseEntity.notFound().build();

        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
