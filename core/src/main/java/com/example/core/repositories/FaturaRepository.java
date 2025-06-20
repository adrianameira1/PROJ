package com.example.core.repositories;

import com.example.core.models.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.core.models.Cliente;
import com.example.core.models.Reserva;
import java.util.List;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Integer> {
    List<Fatura> findByIdEvento_IdReserva_IdCliente_Id(Integer idCliente);
}
