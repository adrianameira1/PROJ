package com.backoffice.model;

import java.time.LocalDate;

public class ReservaRow {
    private String nome;
    private String email; // vem do Cliente relacionado
    private LocalDate data;
    private String status;

    public ReservaRow(String nome, String email, LocalDate data, String status) {
        this.nome = nome;
        this.email = email;
        this.data = data;
        this.status = status;
    }

    // Getters
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public LocalDate getData() { return data; }
    public String getStatus() { return status; }
}
