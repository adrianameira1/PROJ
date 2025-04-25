package com.example.projetoii_dados.reps;

import com.example.projetoii_dados.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    // Se precisar de queries customizadas, declare aqui.
}
