package com.example.projetoii_dados.services;

import com.example.core.models.Tiposervico;
import com.example.core.repositories.TipoServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoServicoService {

    private final TipoServicoRepository repository;

    public TipoServicoService(TipoServicoRepository repository) {
        this.repository = repository;
    }

    public List<Tiposervico> findAll() {
        return repository.findAll();
    }

    public Tiposervico findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Tiposervico save(Tiposervico tiposervico) {
        return repository.save(tiposervico);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
