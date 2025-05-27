package com.example.core.models;

import java.io.Serializable;
import java.util.Objects;

public class EventofuncionarioId implements Serializable {
    private Integer idEvento;
    private Integer idFuncionario;

    public EventofuncionarioId() {}

    public EventofuncionarioId(Integer idEvento, Integer idFuncionario) {
        this.idEvento = idEvento;
        this.idFuncionario = idFuncionario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventofuncionarioId)) return false;
        EventofuncionarioId that = (EventofuncionarioId) o;
        return Objects.equals(idEvento, that.idEvento) &&
                Objects.equals(idFuncionario, that.idFuncionario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEvento, idFuncionario);
    }
}
