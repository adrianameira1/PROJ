package com.example.projetoii_dados.reps;

import com.example.projetoii_dados.models.ServicoFornecedor;
import com.example.projetoii_dados.models.ServicoFornecedorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoFornecedorRepository extends JpaRepository<ServicoFornecedor, ServicoFornecedorId> {
    // Se precisar de queries customizadas, declare aqui.
}
