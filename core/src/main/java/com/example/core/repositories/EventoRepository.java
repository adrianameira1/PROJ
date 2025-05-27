package com.example.core.repositories;

import com.example.core.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
    // Se precisar de queries customizadas, declare aqui.
}
