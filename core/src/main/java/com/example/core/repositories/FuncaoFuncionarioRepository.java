package com.example.core.repositories;

import com.example.core.models.Funcaofuncionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncaoFuncionarioRepository extends JpaRepository<Funcaofuncionario, Integer> {
}
