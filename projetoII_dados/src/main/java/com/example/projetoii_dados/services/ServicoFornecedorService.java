package com.example.projetoii_dados.services;

import com.example.core.models.ServicoFornecedor;
import com.example.core.models.ServicoFornecedorId;
import com.example.core.repositories.ServicoFornecedorRepository;
import org.springframework.stereotype.Service;


import java.util.List;



@Service
public class ServicoFornecedorService {

    private final ServicoFornecedorRepository servicoFornecedorRepository;

    public ServicoFornecedorService(ServicoFornecedorRepository servicoFornecedorRepository) {
        this.servicoFornecedorRepository = servicoFornecedorRepository;
    }

    public List<ServicoFornecedor> findAll() {
        return servicoFornecedorRepository.findAll();
    }

    public ServicoFornecedor findById(ServicoFornecedorId id) {
        return servicoFornecedorRepository.findById(id).orElse(null);
    }

    public ServicoFornecedor save(ServicoFornecedor sf) {
        return servicoFornecedorRepository.save(sf);
    }

    public void deleteById(ServicoFornecedorId id) {
        servicoFornecedorRepository.deleteById(id);
    }
}
