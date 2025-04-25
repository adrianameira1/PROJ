package com.example.projetoii_dados.reps;

import com.example.projetoii_dados.models.Eventofuncionario;
import com.example.projetoii_dados.models.EventofuncionarioId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoFuncionarioRepository extends JpaRepository<Eventofuncionario, EventofuncionarioId> {
    // Se precisar de queries customizadas, declare aqui.
}
