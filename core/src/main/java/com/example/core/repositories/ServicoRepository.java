package com.example.core.repositories;

import com.example.core.models.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

    @Query("SELECT s FROM Servico s WHERE s.idEvento.id = :idEvento")
    List<Servico> findByEventoId(@Param("idEvento") Integer idEvento);

    @Modifying
    @Transactional
    @Query("DELETE FROM Servico s WHERE s.idEvento.id = :idEvento")
    void deleteByEventoId(@Param("idEvento") Integer idEvento);
}

