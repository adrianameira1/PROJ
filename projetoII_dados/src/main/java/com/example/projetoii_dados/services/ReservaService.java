package com.example.projetoii_dados.services;

import com.example.core.models.Reserva;
import com.example.core.repositories.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository repository;

    public ReservaService(ReservaRepository repository) {
        this.repository = repository;
    }

    public List<Reserva> findAll() {
        return repository.findAll();
    }

    public Reserva findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Reserva save(Reserva reserva) {
        return repository.save(reserva);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
