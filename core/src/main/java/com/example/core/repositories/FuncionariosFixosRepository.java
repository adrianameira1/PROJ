package com.example.core.repositories;

import com.example.core.models.Funcionariosfixo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionariosFixosRepository extends JpaRepository<Funcionariosfixo, Long> {
    // Aqui você pode adicionar métodos customizados, se necessário.
}

