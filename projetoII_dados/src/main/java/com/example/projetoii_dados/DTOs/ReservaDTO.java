package com.example.projetoii_dados.DTOs;

import java.time.LocalDate;

public class ReservaDTO {
    private String nome;
    private String status;
    private LocalDate data;
    private Integer numeroconvidados;
    private Integer idCliente;

    public ReservaDTO() {}

    public ReservaDTO(String nome, String status, LocalDate data, Integer numeroconvidados, Integer idCliente) {
        this.nome = nome;
        this.status = status;
        this.data = data;
        this.numeroconvidados = numeroconvidados;
        this.idCliente = idCliente;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public Integer getNumeroconvidados() { return numeroconvidados; }
    public void setNumeroconvidados(Integer numeroconvidados) { this.numeroconvidados = numeroconvidados; }

    public Integer getIdCliente() { return idCliente; }
    public void setIdCliente(Integer idCliente) { this.idCliente = idCliente; }
}
