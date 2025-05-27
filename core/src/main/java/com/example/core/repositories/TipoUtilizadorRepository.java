package com.example.core.repositories;

import com.example.core.models.Tipoutilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUtilizadorRepository extends JpaRepository<Tipoutilizador, Integer> {
}

