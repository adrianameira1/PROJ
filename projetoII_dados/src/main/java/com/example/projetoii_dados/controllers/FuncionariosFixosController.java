package com.example.projetoii_dados.controllers;

import com.example.core.models.Funcionariosfixo;
import com.example.core.models.Funcaofuncionario;
import com.example.core.repositories.FuncaoFuncionarioRepository;

import com.example.projetoii_dados.DTOs.FuncionariosFixosDTO;
import com.example.projetoii_dados.services.FuncionariosFixosService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/funcionarios-fixos")
@Tag(name = "Funcionários Fixos", description = "Endpoints para manipular funcionários fixos")
public class FuncionariosFixosController {

    private final FuncionariosFixosService funcionariosFixosService;
    private final FuncaoFuncionarioRepository funcaoFuncionarioRepository;

    public FuncionariosFixosController(FuncionariosFixosService funcionariosFixosService,
                                       FuncaoFuncionarioRepository funcaoFuncionarioRepository) {
        this.funcionariosFixosService = funcionariosFixosService;
        this.funcaoFuncionarioRepository =funcaoFuncionarioRepository;
    }

    @GetMapping
    public List<FuncionariosFixosDTO> getAll() {
        return funcionariosFixosService.findAll().stream()
                .map(f -> {
                    Integer idFuncao = (f.getFuncao() != null) ? f.getFuncao().getId() : null;
                    return new FuncionariosFixosDTO(
                            f.getNome(),
                            f.getContacto(),
                            idFuncao
                    );
                })
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody FuncionariosFixosDTO dto) {
        Funcaofuncionario funcao = funcaoFuncionarioRepository.findById(dto.getIdFuncao()).orElse(null);
        if (funcao == null) return ResponseEntity.badRequest().build();

        Funcionariosfixo f = new Funcionariosfixo();
        f.setNome(dto.getNome());
        f.setContacto(dto.getContacto());
        f.setFuncao(funcao); // <- aqui está o nome correto

        funcionariosFixosService.save(f);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody FuncionariosFixosDTO dto) {
        Funcionariosfixo existing = funcionariosFixosService.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();

        Funcaofuncionario funcao = funcaoFuncionarioRepository.findById(dto.getIdFuncao()).orElse(null);
        if (funcao == null) return ResponseEntity.badRequest().build();

        existing.setNome(dto.getNome());
        existing.setContacto(dto.getContacto());
        existing.setFuncao(funcao); // <- também aqui

        funcionariosFixosService.save(existing);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Funcionariosfixo existing = funcionariosFixosService.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();

        funcionariosFixosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
