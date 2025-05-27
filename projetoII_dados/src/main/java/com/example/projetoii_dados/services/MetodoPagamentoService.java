package com.example.projetoii_dados.services;

import com.example.core.models.Metodopagamento;
import com.example.core.repositories.MetodoPagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetodoPagamentoService {

    private final MetodoPagamentoRepository repository;

    public MetodoPagamentoService(MetodoPagamentoRepository repository) {
        this.repository = repository;
    }

    public List<Metodopagamento> findAll() {
        return repository.findAll();
    }

    public Metodopagamento findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Metodopagamento save(Metodopagamento m) {
        return repository.save(m);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
