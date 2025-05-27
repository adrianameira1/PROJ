package com.example.projetoii_dados.services;

import com.example.core.models.Tipofatura;
import com.example.core.repositories.TipofaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipofaturaService {

    private final TipofaturaRepository repository;

    public TipofaturaService(TipofaturaRepository repository) {
        this.repository = repository;
    }

    public List<Tipofatura> findAll() {
        return repository.findAll();
    }

    public Tipofatura findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Tipofatura save(Tipofatura tipofatura) {
        return repository.save(tipofatura);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
