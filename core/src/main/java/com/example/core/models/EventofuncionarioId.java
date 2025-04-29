package com.example.core.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EventofuncionarioId implements java.io.Serializable {
    private static final long serialVersionUID = -4820851459733619871L;

    @Column(name = "id_evento", nullable = false)
    private Integer idEvento;

    @Column(name = "id_funcionario", nullable = false)
    private Integer idFuncionario;

    // Construtor SEM argumentos (caso o JPA precise)
    public EventofuncionarioId() {
    }

    // Construtor COM os dois parâmetros
    public EventofuncionarioId(Integer idEvento, Integer idFuncionario) {
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
