package com.backoffice.Service;

import com.example.core.models.Reserva;
import com.example.core.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    // Listar todas as reservas
    public List<Reserva> listarTodas() {
        return reservaRepository.findAll();
    }

    // Guardar (inserir ou atualizar)
    public Reserva guardar(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // Eliminar reserva (opcional)
    public void eliminar(Integer id) {
        reservaRepository.deleteById(id);
    }
}
