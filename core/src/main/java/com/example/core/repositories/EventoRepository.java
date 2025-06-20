package com.example.core.repositories;

import com.example.core.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
    List<Evento> findByIdReserva_IdCliente_Id(Integer idCliente);
}

