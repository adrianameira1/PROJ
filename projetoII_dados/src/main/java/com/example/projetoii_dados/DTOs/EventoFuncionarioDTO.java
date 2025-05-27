package com.example.projetoii_dados.dtos;

public class EventoFuncionarioDTO {
    private Integer idEvento;
    private Integer idFuncionario;

    public EventoFuncionarioDTO() {}

    public EventoFuncionarioDTO(Integer idEvento, Integer idFuncionario) {
        this.idEvento = idEvento;
        this.idFuncionario = idFuncionario;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}
