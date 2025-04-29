package com.example.core.repositories;

import com.example.core.models.Tipofatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoFaturaRepository extends JpaRepository<Tipofatura, Long> {
}
