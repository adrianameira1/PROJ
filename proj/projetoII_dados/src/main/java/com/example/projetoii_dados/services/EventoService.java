package com.example.projetoii_dados.services;

import com.example.projetoii_dados.models.Evento;
import com.example.projetoii_dados.reps.EventoRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public List<Evento> findAll() {
        return eventoRepository.findAll();
    }

    public Evento findById(Long id) {
        return eventoRepository.findById(id).orElse(null);
    }

    public Evento save(Evento evento) {
        return eventoRepository.save(evento);
    }

    public void deleteById(Long id) {
        eventoRepository.deleteById(id);
    }
}
