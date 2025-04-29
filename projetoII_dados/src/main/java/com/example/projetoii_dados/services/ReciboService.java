package com.example.projetoii_dados.services;

import com.example.core.models.Recibo;
import com.example.core.repositories.ReciboRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReciboService {

    private final ReciboRepository reciboRepository;

    public ReciboService(ReciboRepository reciboRepository) {
        this.reciboRepository = reciboRepository;
    }

    public List<Recibo> findAll() {
        return reciboRepository.findAll();
    }

    public Recibo findById(Long id) {
        return reciboRepository.findById(id).orElse(null);
    }

    public Recibo save(Recibo recibo) {
        return reciboRepository.save(recibo);
    }

    public void deleteById(Long id) {
        reciboRepository.deleteById(id);
    }
}
