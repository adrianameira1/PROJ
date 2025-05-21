package com.backoffice.model;

import java.time.LocalDate;

public class ReservaRow {
    private Integer id;
    private String nome;
    private String status;
    private String data;
    private Integer numeroConvidados;

    public ReservaRow(Integer id, String nome, String status, String data, Integer numeroConvidados) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.data = data;
        this.numeroConvidados = numeroConvidados;
    }

    public Integer getId() { return id; }
    public String getNome() { return nome; }
    public String getStatus() { return status; }
    public String getData() { return data; }
    public Integer getNumeroConvidados() { return numeroConvidados; }
}
