package com.example.projetoii_dados.services;

import com.example.core.models.Recibo;
import com.example.core.repositories.ReciboRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReciboService {

    private final ReciboRepository repository;

    public ReciboService(ReciboRepository repository) {
        this.repository = repository;
    }

    public List<Recibo> findAll() {
        return repository.findAll();
    }

    public Recibo findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Recibo save(Recibo recibo) {
        return repository.save(recibo);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
