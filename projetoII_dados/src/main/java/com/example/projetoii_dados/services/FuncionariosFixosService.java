package com.example.projetoii_dados.services;

import com.example.core.models.Funcionariosfixo;
import com.example.core.repositories.FuncionariosFixosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionariosFixosService {

    private final FuncionariosFixosRepository repository;

    public FuncionariosFixosService(FuncionariosFixosRepository repository) {
        this.repository = repository;
    }

    public List<Funcionariosfixo> findAll() {
        return repository.findAll();
    }

    public Funcionariosfixo findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Funcionariosfixo save(Funcionariosfixo funcionario) {
        return repository.save(funcionario);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
