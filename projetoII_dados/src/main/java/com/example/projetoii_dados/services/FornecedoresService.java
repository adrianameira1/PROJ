package com.example.projetoii_dados.services;

import com.example.core.models.Fornecedore;
import com.example.core.repositories.FornecedoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedoresService {

    private final FornecedoresRepository fornecedoresRepository;

    public FornecedoresService(FornecedoresRepository fornecedoresRepository) {
        this.fornecedoresRepository = fornecedoresRepository;
    }

    public List<Fornecedore> findAll() {
        return fornecedoresRepository.findAll();
    }

    public Fornecedore findById(Long id) {
        return fornecedoresRepository.findById(id).orElse(null);
    }

    public Fornecedore save(Fornecedore fornecedor) {
        return fornecedoresRepository.save(fornecedor);
    }

    public void deleteById(Long id) {
        fornecedoresRepository.deleteById(id);
    }
}
