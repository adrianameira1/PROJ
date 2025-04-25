package com.example.projetoii_dados.reps;

import com.example.projetoii_dados.models.Tipoutilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUtilizadorRepository extends JpaRepository<Tipoutilizador, Long> {
}

