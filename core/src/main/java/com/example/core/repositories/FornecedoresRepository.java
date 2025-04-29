package com.example.core.repositories;

import com.example.core.models.Fornecedore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedoresRepository extends JpaRepository<Fornecedore, Long> {
    // Se precisar de queries customizadas, declare aqui.
}
