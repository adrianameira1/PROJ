package com.example.projetoii_dados.services;

import com.example.core.models.Funcionariosfixo;
import com.example.core.repositories.FuncionariosFixosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionariosFixosService {

    @Autowired
    private FuncionariosFixosRepository repository;

    public List<Funcionariosfixo> findAll() {
        return repository.findAll();
    }

    public Funcionariosfixo findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Funcionariosfixo save(Funcionariosfixo funcionario) {
        return repository.save(funcionario);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

