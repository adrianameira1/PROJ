package com.example.projetoii_dados.DTOs;

public class LoginResponseDTO {
    private Integer idCliente;
    private String nome;

    public LoginResponseDTO(Integer idCliente, String nome) {
        this.idCliente = idCliente;
        this.nome = nome;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }
}
