package com.example.core.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ServicoFornecedorId implements Serializable {

    private static final long serialVersionUID = 6189685793026140303L;

    @Column(name = "id_fornecedor", nullable = false)
    private Integer idFornecedor;

    @Column(name = "id_servico", nullable = false)
    private Integer idServico;

    // Construtor vazio (JPA exige um construtor padrão)
    public ServicoFornecedorId() {
    }

    // Construtor que recebe os dois parâmetros
    public ServicoFornecedorId(Integer idFornecedor, Integer idServico) {
        this.idFornecedor = idFornecedor;
        this.idServico = idServico;
    }

    // Getters
    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public Integer getIdServico() {
        return idServico;
    }

    // Setters
    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ServicoFornecedorId entity = (ServicoFornecedorId) o;
        return Objects.equals(this.idFornecedor, entity.idFornecedor) &&
                Objects.equals(this.idServico, entity.idServico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFornecedor, idServico);
    }
}
