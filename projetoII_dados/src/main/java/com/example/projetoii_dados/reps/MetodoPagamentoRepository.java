package com.example.projetoii_dados.reps;

import com.example.projetoii_dados.models.Metodopagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoPagamentoRepository extends JpaRepository<Metodopagamento, Long> {
}

