package com.example.projetoii_dados.DTOs;

public class FuncionariosFixosDTO {
    private String nome;
    private String contacto;
    private Integer idFuncao;

    public FuncionariosFixosDTO() {}

    public FuncionariosFixosDTO(String nome, String contacto, Integer idFuncao) {
        this.nome = nome;
        this.contacto = contacto;
        this.idFuncao = idFuncao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Integer getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(Integer idFuncao) {
        this.idFuncao = idFuncao;
    }
}
