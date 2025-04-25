package com.example.projetoii_dados.services;

import com.example.projetoii_dados.models.Cliente;
import com.example.projetoii_dados.reps.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente save(Cliente clientee) {
        Cliente cliente = new Cliente();
        cliente.setNome(clientee.getNome());
        cliente.setEmail(clientee.getEmail());
        cliente.setTelefone(clientee.getTelefone());
        return clienteRepository.save(cliente);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    // Outras regras de negócio podem ir aqui.
}
