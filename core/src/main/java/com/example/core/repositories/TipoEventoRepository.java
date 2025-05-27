package com.example.core.repositories;

import com.example.core.models.Tipoevento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEventoRepository extends JpaRepository<Tipoevento, Integer> {
}

