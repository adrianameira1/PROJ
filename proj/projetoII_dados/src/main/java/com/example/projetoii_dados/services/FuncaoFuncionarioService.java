package com.example.projetoii_dados.services;

import com.example.projetoii_dados.models.Funcaofuncionario;
import com.example.projetoii_dados.reps.FuncaoFuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncaoFuncionarioService {

    @Autowired
    private FuncaoFuncionarioRepository repository;

    public List<Funcaofuncionario> findAll() {
        return repository.findAll();
    }

    public Funcaofuncionario findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Funcaofuncionario save(Funcaofuncionario entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

