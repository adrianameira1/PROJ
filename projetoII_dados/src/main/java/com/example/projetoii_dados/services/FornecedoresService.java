package com.example.projetoii_dados.services;

import com.example.core.models.Fornecedor;
import com.example.core.repositories.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedoresService {

    private final FornecedorRepository fornecedoresRepository;

    public FornecedoresService(FornecedorRepository fornecedoresRepository) {
        this.fornecedoresRepository = fornecedoresRepository;
    }

    public List<Fornecedor> findAll() {
        return fornecedoresRepository.findAll();
    }

    public Fornecedor findById(Integer id) {
        return fornecedoresRepository.findById(id).orElse(null);
    }

    public Fornecedor save(Fornecedor fornecedor) {
        return fornecedoresRepository.save(fornecedor);
    }

    public void deleteById(Integer id) {
        fornecedoresRepository.deleteById(id);
    }
}
