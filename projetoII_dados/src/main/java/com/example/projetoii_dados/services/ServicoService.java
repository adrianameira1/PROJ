package com.example.projetoii_dados.services;

import com.example.projetoii_dados.models.Servico;
import com.example.projetoii_dados.reps.ServicoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;

    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public List<Servico> findAll() {
        return servicoRepository.findAll();
    }

    public Servico findById(Long id) {
        return servicoRepository.findById(id).orElse(null);
    }

    public Servico save(Servico servico) {
        return servicoRepository.save(servico);
    }

    public void deleteById(Long id) {
        servicoRepository.deleteById(id);
    }
}
