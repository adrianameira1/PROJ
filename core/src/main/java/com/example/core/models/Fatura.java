package com.example.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "fatura")
public class Fatura {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fatura_id_gen")
    @SequenceGenerator(name = "fatura_id_gen", sequenceName = "fatura_id_fatura_seq", allocationSize = 1)
    @Column(name = "id_fatura", nullable = false)
    private Integer id;

    @Column(name = "valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "dtemissao", nullable = false)
    private LocalDate dtemissao;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "dtpagamento")
    private LocalDate dtpagamento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento idEvento;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipofatura", nullable = false)
    private Tipofatura idTipofatura;

    @JsonIgnore
    @OneToMany(mappedBy = "idFatura")
    private Set<Recibo> recibos = new LinkedHashSet<>();

    // Getters e setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDtemissao() {
        return dtemissao;
    }

    public void setDtemissao(LocalDate dtemissao) {
        this.dtemissao = dtemissao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDtpagamento() {
        return dtpagamento;
    }

    public void setDtpagamento(LocalDate dtpagamento) {
        this.dtpagamento = dtpagamento;
    }

    public Evento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Evento idEvento) {
        this.idEvento = idEvento;
    }

    public Tipofatura getIdTipofatura() {
        return idTipofatura;
    }

    public void setIdTipofatura(Tipofatura idTipofatura) {
        this.idTipofatura = idTipofatura;
    }

    public Set<Recibo> getRecibos() {
        return recibos;
    }

    public void setRecibos(Set<Recibo> recibos) {
        this.recibos = recibos;
    }
}
