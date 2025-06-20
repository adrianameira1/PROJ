package com.example.core.repositories;

import com.example.core.models.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface UtilizadorRepository extends JpaRepository<Utilizador, Integer> {
    boolean existsByUsername(String username);

    Optional<Utilizador> findByUsername(String username);

}

