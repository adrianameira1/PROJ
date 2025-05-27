package com.example.projetoii_dados.services;

import com.example.core.models.ServicoFornecedor;
import com.example.core.models.ServicoFornecedorId;
import com.example.core.repositories.ServicoFornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoFornecedorService {

    private final ServicoFornecedorRepository repository;

    public ServicoFornecedorService(ServicoFornecedorRepository repository) {
        this.repository = repository;
    }

    public List<ServicoFornecedor> findAll() {
        return repository.findAll();
    }

    public ServicoFornecedor findById(ServicoFornecedorId id) {
        return repository.findById(id).orElse(null);
    }

    public ServicoFornecedor save(ServicoFornecedor entity) {
        return repository.save(entity);
    }

    public void deleteById(ServicoFornecedorId id) {
        repository.deleteById(id);
    }
}
