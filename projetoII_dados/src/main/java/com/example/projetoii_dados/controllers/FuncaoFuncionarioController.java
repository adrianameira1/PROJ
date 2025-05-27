package com.example.projetoii_dados.controllers;

import com.example.core.models.Funcaofuncionario;
import com.example.projetoii_dados.DTOs.FuncaoFuncionarioDTO;
import com.example.projetoii_dados.services.FuncaoFuncionarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/funcoes")
@Tag(name = "Funções de Funcionário", description = "Endpoints para manipular funções de funcionários")
public class FuncaoFuncionarioController {

    private final FuncaoFuncionarioService funcaoFuncionarioService;

    public FuncaoFuncionarioController(FuncaoFuncionarioService funcaoFuncionarioService) {
        this.funcaoFuncionarioService = funcaoFuncionarioService;
    }

    @GetMapping
    public List<FuncaoFuncionarioDTO> getAll() {
        return funcaoFuncionarioService.findAll().stream()
                .map(f -> new FuncaoFuncionarioDTO(f.getDesignacao()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncaoFuncionarioDTO> getById(@PathVariable Integer id) {
        Funcaofuncionario f = funcaoFuncionarioService.findById(id);
        if (f == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new FuncaoFuncionarioDTO(f.getDesignacao()));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody FuncaoFuncionarioDTO dto) {
        Funcaofuncionario f = new Funcaofuncionario();
        f.setDesignacao(dto.getDesignacao());
        funcaoFuncionarioService.save(f);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody FuncaoFuncionarioDTO dto) {
        Funcaofuncionario existing = funcaoFuncionarioService.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();

        existing.setDesignacao(dto.getDesignacao());
        funcaoFuncionarioService.save(existing);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Funcaofuncionario existing = funcaoFuncionarioService.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();

        funcaoFuncionarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
