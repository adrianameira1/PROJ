package com.example.projetoii_dados.services;

import com.example.projetoii_dados.models.Metodopagamento;
import com.example.projetoii_dados.reps.MetodoPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetodoPagamentoService {

    @Autowired
    private MetodoPagamentoRepository repository;

    public List<Metodopagamento> findAll() {
        return repository.findAll();
    }

    public Metodopagamento findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Metodopagamento save(Metodopagamento mp) {
        return repository.save(mp);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

