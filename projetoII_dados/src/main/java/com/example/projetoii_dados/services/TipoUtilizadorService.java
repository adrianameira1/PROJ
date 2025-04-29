package com.example.projetoii_dados.services;

import com.example.core.models.Tipoutilizador;
import com.example.core.repositories.TipoUtilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUtilizadorService {

    @Autowired
    private TipoUtilizadorRepository repository;

    public List<Tipoutilizador> findAll() {
        return repository.findAll();
    }

    public Tipoutilizador findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Tipoutilizador save(Tipoutilizador entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

