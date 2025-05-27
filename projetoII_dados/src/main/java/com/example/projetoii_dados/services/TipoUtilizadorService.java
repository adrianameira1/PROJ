package com.example.projetoii_dados.services;

import com.example.core.models.Tipoutilizador;
import com.example.core.repositories.TipoUtilizadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUtilizadorService {

    private final TipoUtilizadorRepository repository;

    public TipoUtilizadorService(TipoUtilizadorRepository repository) {
        this.repository = repository;
    }

    public List<Tipoutilizador> findAll() {
        return repository.findAll();
    }

    public Tipoutilizador findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Tipoutilizador save(Tipoutilizador tipoutilizador) {
        return repository.save(tipoutilizador);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
