package com.example.projetoii_dados.services;

import com.example.core.models.Funcaofuncionario;
import com.example.core.repositories.FuncaoFuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncaoFuncionarioService {

    private final FuncaoFuncionarioRepository repository;

    public FuncaoFuncionarioService(FuncaoFuncionarioRepository repository) {
        this.repository = repository;
    }

    public List<Funcaofuncionario> findAll() {
        return repository.findAll();
    }

    public Funcaofuncionario findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Funcaofuncionario save(Funcaofuncionario f) {
        return repository.save(f);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
