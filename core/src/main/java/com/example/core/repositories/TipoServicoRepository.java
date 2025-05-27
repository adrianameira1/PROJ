package com.example.core.repositories;

import com.example.core.models.Tiposervico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoServicoRepository extends JpaRepository<Tiposervico, Integer> {
}
