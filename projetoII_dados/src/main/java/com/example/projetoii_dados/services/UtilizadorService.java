package com.example.projetoii_dados.services;

import com.example.core.models.Utilizador;
import com.example.core.repositories.UtilizadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilizadorService {

    private final UtilizadorRepository repository;

    public UtilizadorService(UtilizadorRepository repository) {
        this.repository = repository;
    }

    public List<Utilizador> findAll() {
        return repository.findAll();
    }

    public Utilizador findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Utilizador save(Utilizador utilizador) {
        return repository.save(utilizador);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
