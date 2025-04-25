package com.example.projetoii_dados.reps;

import com.example.projetoii_dados.models.Recibo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReciboRepository extends JpaRepository<Recibo, Long> {
    // Se precisar de queries customizadas, declare aqui.
}
