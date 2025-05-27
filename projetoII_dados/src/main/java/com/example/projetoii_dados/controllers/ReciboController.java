package com.example.projetoii_dados.controllers;

import com.example.core.models.Evento;
import com.example.core.models.Metodopagamento;
import com.example.core.models.Recibo;
import com.example.core.repositories.EventoRepository;
import com.example.core.repositories.MetodoPagamentoRepository;
import com.example.projetoii_dados.DTOs.ReciboDTO;
import com.example.projetoii_dados.services.ReciboService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/recibos")
@Tag(name = "Recibos", description = "Endpoints para manipular recibos")
public class ReciboController {

    private final ReciboService reciboService;
    private final EventoRepository eventoRepository;
    private final MetodoPagamentoRepository metodoPagamentoRepository;

    public ReciboController(ReciboService reciboService,
                            EventoRepository eventoRepository,
                            MetodoPagamentoRepository metodoPagamentoRepository) {
        this.reciboService = reciboService;
        this.eventoRepository = eventoRepository;
        this.metodoPagamentoRepository = metodoPagamentoRepository;
    }

    @GetMapping
    public List<ReciboDTO> getAll() {
        return reciboService.findAll().stream()
                .map(r -> new ReciboDTO(
                        r.getNumerorecibo(),
                        r.getDescricao(),
                        r.getQuantidade(),
                        r.getValorunitario(),
                        r.getValortotal(),
                        r.getDataemissao(),
                        r.getDtpagamento(),
                        r.getObservacoes(),
                        r.getIdEvento().getId(),
                        r.getIdMetodoPagamento().getId()
                )).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReciboDTO> getById(@PathVariable Integer id) {
        Recibo r = reciboService.findById(id);
        if (r == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new ReciboDTO(
                r.getNumerorecibo(),
                r.getDescricao(),
                r.getQuantidade(),
                r.getValorunitario(),
                r.getValortotal(),
                r.getDataemissao(),
                r.getDtpagamento(),
                r.getObservacoes(),
                r.getIdEvento().getId(),
                r.getIdMetodoPagamento().getId()
        ));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ReciboDTO dto) {
        Evento evento = eventoRepository.findById(dto.getIdEvento()).orElse(null);
        Metodopagamento metodo = metodoPagamentoRepository.findById(dto.getIdMetodoPagamento()).orElse(null);
        if (evento == null || metodo == null) return ResponseEntity.badRequest().build();

        Recibo r = new Recibo();
        r.setNumerorecibo(dto.getNumerorecibo());
        r.setDescricao(dto.getDescricao());
        r.setQuantidade(dto.getQuantidade());
        r.setValorunitario(dto.getValorunitario());
        r.setValortotal(dto.getValortotal());
        r.setDataemissao(dto.getDataemissao());
        r.setDtpagamento(dto.getDtpagamento());
        r.setObservacoes(dto.getObservacoes());
        r.setIdEvento(evento);
        r.setIdMetodoPagamento(metodo);

        reciboService.save(r);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody ReciboDTO dto) {
        Recibo existing = reciboService.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();

        Evento evento = eventoRepository.findById(dto.getIdEvento()).orElse(null);
        Metodopagamento metodo = metodoPagamentoRepository.findById(dto.getIdMetodoPagamento()).orElse(null);
        if (evento == null || metodo == null) return ResponseEntity.badRequest().build();

        existing.setNumerorecibo(dto.getNumerorecibo());
        existing.setDescricao(dto.getDescricao());
        existing.setQuantidade(dto.getQuantidade());
        existing.setValorunitario(dto.getValorunitario());
        existing.setValortotal(dto.getValortotal());
        existing.setDataemissao(dto.getDataemissao());
        existing.setDtpagamento(dto.getDtpagamento());
        existing.setObservacoes(dto.getObservacoes());
        existing.setIdEvento(evento);
        existing.setIdMetodoPagamento(metodo);

        reciboService.save(existing);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Recibo existing = reciboService.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();

        reciboService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
