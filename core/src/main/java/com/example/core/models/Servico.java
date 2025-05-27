package com.example.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "servico")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servico_id_gen")
    @SequenceGenerator(name = "servico_id_gen", sequenceName = "servico_id_servico_seq", allocationSize = 1)
    @Column(name = "id_servico", nullable = false)
    private Integer id;

    @Column(name = "statuspagamento", length = 50)
    private String statuspagamento;

    @Column(name = "detalhesservico", length = Integer.MAX_VALUE)
    private String detalhesservico;

    @Column(name = "custototal", precision = 10, scale = 2)
    private BigDecimal custototal;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento idEvento;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tiposervico", nullable = false)
    private Tiposervico idTiposervico;

    @JsonIgnore
    @ManyToMany(mappedBy = "servicos")
    private Set<Fornecedor> fornecedors = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatuspagamento() {
        return statuspagamento;
    }

    public void setStatuspagamento(String statuspagamento) {
        this.statuspagamento = statuspagamento;
    }

    public String getDetalhesservico() {
        return detalhesservico;
    }

    public void setDetalhesservico(String detalhesservico) {
        this.detalhesservico = detalhesservico;
    }

    public BigDecimal getCustototal() {
        return custototal;
    }

    public void setCustototal(BigDecimal custototal) {
        this.custototal = custototal;
    }

    public Evento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Evento idEvento) {
        this.idEvento = idEvento;
    }

    public Tiposervico getIdTiposervico() {
        return idTiposervico;
    }

    public void setIdTiposervico(Tiposervico idTiposervico) {
        this.idTiposervico = idTiposervico;
    }

    public Set<Fornecedor> getFornecedores() {
        return fornecedors;
    }

    public void setFornecedores(Set<Fornecedor> fornecedors) {
        this.fornecedors = fornecedors;
    }

}