package com.example.projetoii_dados.reps;

import com.example.projetoii_dados.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Se precisar de queries customizadas, declare aqui.
}
