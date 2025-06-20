package com.example.core.repositories;

import com.example.core.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    List<Reserva> findByIdCliente_Id(Integer idCliente);
    boolean existsByData(LocalDate data);

}
