package com.example.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evento_id_gen")
    @SequenceGenerator(name = "evento_id_gen", sequenceName = "evento_id_evento_seq", allocationSize = 1)
    @Column(name = "id_evento", nullable = false)
    private Integer id;

    @Column(name = "orcamento", precision = 10, scale = 2)
    private BigDecimal orcamento;

    @Column(name = "cronograma", length = Integer.MAX_VALUE)
    private String cronograma;

    @Column(name = "statusevento", length = 50)
    private String statusevento;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_reserva", nullable = false)
    private Reserva idReserva;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipoevento", nullable = false)
    private Tipoevento idTipoevento;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "eventofuncionario",
            joinColumns = @JoinColumn(name = "id_evento"),
            inverseJoinColumns = @JoinColumn(name = "id_funcionario"))
    private Set<Funcionariosfixo> funcionariosfixos = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "idEvento")
    private Set<Fatura> faturas = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "idEvento")
    private Set<Servico> servicos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(BigDecimal orcamento) {
        this.orcamento = orcamento;
    }

    public String getCronograma() {
        return cronograma;
    }

    public void setCronograma(String cronograma) {
        this.cronograma = cronograma;
    }

    public String getStatusevento() {
        return statusevento;
    }

    public void setStatusevento(String statusevento) {
        this.statusevento = statusevento;
    }

    public Reserva getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Reserva idReserva) {
        this.idReserva = idReserva;
    }

    public Tipoevento getIdTipoevento() {
        return idTipoevento;
    }

    public void setIdTipoevento(Tipoevento idTipoevento) {
        this.idTipoevento = idTipoevento;
    }

    public Set<Funcionariosfixo> getFuncionariosfixos() {
        return funcionariosfixos;
    }

    public void setFuncionariosfixos(Set<Funcionariosfixo> funcionariosfixos) {
        this.funcionariosfixos = funcionariosfixos;
    }

    public Set<Fatura> getFaturas() {
        return faturas;
    }

    public void setFaturas(Set<Fatura> faturas) {
        this.faturas = faturas;
    }

    public Set<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(Set<Servico> servicos) {
        this.servicos = servicos;
    }

}