package com.example.projetoii_dados.controllers;

import com.example.core.models.Funcionariosfixo;
import com.example.core.models.Funcaofuncionario;
import com.example.core.models.Tipoutilizador;
import com.example.core.models.Utilizador;
import com.example.core.repositories.FuncionariosFixosRepository;
import com.example.core.repositories.FuncaoFuncionarioRepository;
import com.example.core.repositories.TipoUtilizadorRepository;
import com.example.projetoii_dados.DTOs.NovoUtilizadorDTO;
import com.example.projetoii_dados.DTOs.UtilizadorDTO;
import com.example.projetoii_dados.services.UtilizadorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/utilizadores")
@Tag(name = "Utilizadores", description = "Endpoints para manipular utilizadores")
public class UtilizadorController {

    private final UtilizadorService utilizadorService;
    private final FuncionariosFixosRepository funcionariosfixoRepository;
    private final TipoUtilizadorRepository tipoUtilizadorRepository;
    private final FuncaoFuncionarioRepository funcaoFuncionarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UtilizadorController(UtilizadorService utilizadorService,
                                FuncionariosFixosRepository funcionariosfixoRepository,
                                TipoUtilizadorRepository tipoUtilizadorRepository,
                                FuncaoFuncionarioRepository funcaoFuncionarioRepository,
                                PasswordEncoder passwordEncoder) {
        this.utilizadorService = utilizadorService;
        this.funcionariosfixoRepository = funcionariosfixoRepository;
        this.tipoUtilizadorRepository = tipoUtilizadorRepository;
        this.funcaoFuncionarioRepository = funcaoFuncionarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody NovoUtilizadorDTO dto) {
        Tipoutilizador tipo = tipoUtilizadorRepository.findById(dto.idTipouser).orElse(null);
        if (tipo == null) return ResponseEntity.badRequest().build();

        Funcaofuncionario funcao = funcaoFuncionarioRepository.findById(1).orElse(null); // ID 1 = "A definir"
        if (funcao == null) return ResponseEntity.badRequest().build();

        Funcionariosfixo funcionario = new Funcionariosfixo();
        funcionario.setNome(dto.nome);
        funcionario.setContacto(dto.contacto); // usar contacto real
        funcionario.setFuncao(funcao);
        funcionario = funcionariosfixoRepository.save(funcionario);

        Utilizador u = new Utilizador();
        u.setNome(dto.nome);
        u.setUsername(dto.username);
        u.setPasswordHash(passwordEncoder.encode(dto.password));
        u.setIdFuncionario(funcionario);
        u.setIdTipouser(tipo);
        u.setIdCliente(null);

        utilizadorService.save(u);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public List<UtilizadorDTO> getAll() {
        return utilizadorService.findAll().stream()
                .map(u -> new UtilizadorDTO(
                        u.getNome(),
                        u.getUsername(),
                        u.getIdFuncionario() != null ? u.getIdFuncionario().getContacto() : null,
                        u.getIdCliente() != null ? u.getIdCliente().getId() : null,
                        u.getIdFuncionario() != null ? u.getIdFuncionario().getId() : null,
                        u.getIdTipouser() != null ? u.getIdTipouser().getId() : null
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilizadorDTO> getById(@PathVariable Integer id) {
        Utilizador u = utilizadorService.findById(id);
        if (u == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new UtilizadorDTO(
                u.getNome(),
                u.getUsername(),
                u.getIdFuncionario() != null ? u.getIdFuncionario().getContacto() : null,
                u.getIdCliente() != null ? u.getIdCliente().getId() : null,
                u.getIdFuncionario() != null ? u.getIdFuncionario().getId() : null,
                u.getIdTipouser() != null ? u.getIdTipouser().getId() : null
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Utilizador u = utilizadorService.findById(id);
        if (u == null) return ResponseEntity.notFound().build();

        utilizadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
