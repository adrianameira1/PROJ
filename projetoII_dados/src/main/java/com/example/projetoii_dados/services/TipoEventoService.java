package com.example.projetoii_dados.services;

import com.example.core.models.Tipoevento;
import com.example.core.repositories.TipoEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoEventoService {

    @Autowired
    private TipoEventoRepository repository;

    public List<Tipoevento> findAll() {
        return repository.findAll();
    }

    public Tipoevento findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Tipoevento save(Tipoevento entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

