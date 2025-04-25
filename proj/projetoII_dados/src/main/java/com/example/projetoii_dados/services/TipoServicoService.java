package com.example.projetoii_dados.services;

import com.example.projetoii_dados.models.Tiposervico;
import com.example.projetoii_dados.reps.TipoServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoServicoService {

    @Autowired
    private TipoServicoRepository repository;

    public List<Tiposervico> findAll() {
        return repository.findAll();
    }

    public Tiposervico findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Tiposervico save(Tiposervico entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
