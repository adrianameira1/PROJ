package com.example.core.repositories;

import com.example.core.models.Recibo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReciboRepository extends JpaRepository<Recibo, Integer> {
    // Se precisar de queries customizadas, declare aqui.
}
