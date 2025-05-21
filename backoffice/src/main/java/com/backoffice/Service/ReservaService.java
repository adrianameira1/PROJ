package com.backoffice.Service;

import com.example.core.models.Reserva;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ReservaService {

    private final RestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/api/reservas";

    public ReservaService() {
        this.restTemplate = new RestTemplate();
    }

    public List<Reserva> listarTodas() {
        ResponseEntity<Reserva[]> response = restTemplate.getForEntity(BASE_URL, Reserva[].class);
        return Arrays.asList(response.getBody());
    }

    public Reserva guardar(Reserva reserva) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Reserva> request = new HttpEntity<>(reserva, headers);

        if (reserva.getId() == null) {
            // Criar nova reserva
            ResponseEntity<Reserva> response = restTemplate.postForEntity(BASE_URL, request, Reserva.class);
            return response.getBody();
        } else {
            // Atualizar reserva existente
            String url = BASE_URL + "/" + reserva.getId();
            restTemplate.put(url, request);
            return reserva;
        }
    }

    public void eliminar(Integer id) {
        restTemplate.delete(BASE_URL + "/" + id);
    }

    public Reserva buscarPorId(Integer id) {
        return restTemplate.getForObject(BASE_URL + "/" + id, Reserva.class);
    }
}
