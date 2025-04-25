package com.example.projetoii_dados.reps;

import com.example.projetoii_dados.models.Fornecedore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedoresRepository extends JpaRepository<Fornecedore, Long> {
    // Se precisar de queries customizadas, declare aqui.
}
