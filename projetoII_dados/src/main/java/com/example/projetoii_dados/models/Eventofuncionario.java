package com.example.projetoii_dados.models;

import jakarta.persistence.*;

@Entity
@Table(name = "eventofuncionario")
public class Eventofuncionario {
    @SequenceGenerator(name = "eventofuncionario_id_gen", sequenceName = "evento_id_evento_seq", allocationSize = 1)
    @EmbeddedId
    private EventofuncionarioId id;

    @MapsId("idEvento")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento idEvento;

    @MapsId("idFuncionario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_funcionario", nullable = false)
    private Funcionariosfixo idFuncionario;

    public EventofuncionarioId getId() {
        return id;
    }

    public void setId(EventofuncionarioId id) {
        this.id = id;
    }

    public Evento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Evento idEvento) {
        this.idEvento = idEvento;
    }

    public Funcionariosfixo getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionariosfixo idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

}