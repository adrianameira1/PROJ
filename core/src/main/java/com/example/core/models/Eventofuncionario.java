package com.example.core.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "eventofuncionario")
@IdClass(EventofuncionarioId.class)
public class Eventofuncionario implements Serializable {

    @Id
    @Column(name = "id_evento")
    private Integer idEvento;

    @Id
    @Column(name = "id_funcionario")
    private Integer idFuncionario;

    public Eventofuncionario() {}

    public Eventofuncionario(Integer idEvento, Integer idFuncionario) {
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
