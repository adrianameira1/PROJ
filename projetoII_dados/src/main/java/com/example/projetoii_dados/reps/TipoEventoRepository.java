package com.example.projetoii_dados.reps;

import com.example.projetoii_dados.models.Tipoevento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEventoRepository extends JpaRepository<Tipoevento, Long> {
}

