package com.example.core.repositories;

import com.example.core.models.Metodopagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoPagamentoRepository extends JpaRepository<Metodopagamento, Integer> {
}
