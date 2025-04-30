package com.backoffice.Service;

import com.backoffice.model.Utilizador;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.Collections;
import java.util.List;

public class ApiService {
    private static final String BASE_URL = "http://localhost:8080/api/utilizadores";
    private static final HttpClient client = HttpClient.newHttpClient();

    public static List<Utilizador> getUtilizadores() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        System.out.println("RESPOSTA RECEBIDA:");
        System.out.println(response.body());

        // ADICIONAR VERIFICAÇÃO DE STATUS
        if (response.statusCode() == 200) {
            return mapper.readValue(response.body(), new TypeReference<List<Utilizador>>() {});
        } else {
            System.out.println("Erro ao buscar utilizadores. Status: " + response.statusCode());
            return Collections.emptyList(); // ou podes lançar exceção, dependendo do que quiseres fazer
        }
    }
}
