package com.example.projetoii_dados.reps;

import com.example.projetoii_dados.models.Tipofatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoFaturaRepository extends JpaRepository<Tipofatura, Long> {
}
