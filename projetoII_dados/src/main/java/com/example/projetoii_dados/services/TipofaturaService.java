package com.example.projetoii_dados.services;

import com.example.core.models.Tipofatura;
import com.example.core.repositories.TipoFaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipofaturaService {

    private final TipoFaturaRepository tipofaturaRepository;

    public TipofaturaService(TipoFaturaRepository tipofaturaRepository) {
        this.tipofaturaRepository = tipofaturaRepository;
    }

    public List<Tipofatura> findAll() {
        return tipofaturaRepository.findAll();
    }

    public Tipofatura findById(Long id) {
        return tipofaturaRepository.findById(id).orElse(null);
    }

    public Tipofatura save(Tipofatura tipofatura) {
        return tipofaturaRepository.save(tipofatura);
    }

    public void deleteById(Long id) {
        tipofaturaRepository.deleteById(id);
    }
}
