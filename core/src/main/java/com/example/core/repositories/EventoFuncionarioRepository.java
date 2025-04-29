package com.example.core.repositories;

import com.example.core.models.Eventofuncionario;
import com.example.core.models.EventofuncionarioId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoFuncionarioRepository extends JpaRepository<Eventofuncionario, EventofuncionarioId> {
    // Se precisar de queries customizadas, declare aqui.
}
