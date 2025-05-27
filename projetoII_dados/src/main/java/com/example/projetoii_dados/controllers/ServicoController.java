package com.example.projetoii_dados.controllers;

import com.example.core.models.Evento;
import com.example.core.models.Servico;
import com.example.core.models.Tiposervico;
import com.example.core.repositories.EventoRepository;
import com.example.core.repositories.TipoServicoRepository;
import com.example.projetoii_dados.DTOs.ServicoDTO;
import com.example.projetoii_dados.services.ServicoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/servicos")
@Tag(name = "Serviços", description = "Endpoints para manipular serviços")
public class ServicoController {

    private final ServicoService servicoService;
    private final EventoRepository eventoRepository;
    private final TipoServicoRepository tiposervicoRepository;

    public ServicoController(ServicoService servicoService,
                             EventoRepository eventoRepository,
                             TipoServicoRepository tiposervicoRepository) {
        this.servicoService = servicoService;
        this.eventoRepository = eventoRepository;
        this.tiposervicoRepository = tiposervicoRepository;
    }

    @GetMapping
    public List<ServicoDTO> getAll() {
        return servicoService.findAll().stream()
                .map(s -> new ServicoDTO(
                        s.getStatuspagamento(),
                        s.getDetalhesservico(),
                        s.getCustototal(),
                        s.getIdEvento().getId(),
                        s.getIdTiposervico().getId()
                )).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoDTO> getById(@PathVariable Integer id) {
        Servico s = servicoService.findById(id);
        if (s == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new ServicoDTO(
                s.getStatuspagamento(),
                s.getDetalhesservico(),
                s.getCustototal(),
                s.getIdEvento().getId(),
                s.getIdTiposervico().getId()
        ));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ServicoDTO dto) {
        Evento evento = eventoRepository.findById(dto.getIdEvento()).orElse(null);
        Tiposervico tipo = tiposervicoRepository.findById(dto.getIdTiposervico().intValue()).orElse(null);
        if (evento == null || tipo == null) return ResponseEntity.badRequest().build();

        Servico s = new Servico();
        s.setStatuspagamento(dto.getStatuspagamento());
        s.setDetalhesservico(dto.getDetalhesservico());
        s.setCustototal(dto.getCustototal());
        s.setIdEvento(evento);
        s.setIdTiposervico(tipo);

        servicoService.save(s);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody ServicoDTO dto) {
        Servico existing = servicoService.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();

        Evento evento = eventoRepository.findById(dto.getIdEvento()).orElse(null);
        Tiposervico tipo = tiposervicoRepository.findById(dto.getIdTiposervico().intValue()).orElse(null);
        if (evento == null || tipo == null) return ResponseEntity.badRequest().build();

        existing.setStatuspagamento(dto.getStatuspagamento());
        existing.setDetalhesservico(dto.getDetalhesservico());
        existing.setCustototal(dto.getCustototal());
        existing.setIdEvento(evento);
        existing.setIdTiposervico(tipo);

        servicoService.save(existing);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Servico existing = servicoService.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();

        servicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
