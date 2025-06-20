package com.example.core.repositories;

import com.example.core.models.Recibo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.core.models.Cliente;
import java.util.List;


@Repository
public interface ReciboRepository extends JpaRepository<Recibo, Integer> {
    List<Recibo> findByIdFatura_IdEvento_IdReserva_IdCliente_Id(Integer idCliente);
}
