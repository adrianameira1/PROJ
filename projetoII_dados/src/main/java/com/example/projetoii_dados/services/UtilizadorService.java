package com.example.projetoii_dados.services;

import com.example.core.models.Utilizador;
import com.example.core.repositories.UtilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilizadorService {

    @Autowired
    private UtilizadorRepository utilizadorRepository;

    public List<Utilizador> getAllUtilizadores() {
        return utilizadorRepository.findAll();
    }

    public Utilizador getUtilizadorById(Integer id) {
        return utilizadorRepository.findById(id).orElse(null);
    }

    public Utilizador saveUtilizador(Utilizador utilizador) {
        return utilizadorRepository.save(utilizador);
    }

    public void deleteUtilizador(Integer id) {
        utilizadorRepository.deleteById(id);
    }
}
