package com.example.core.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "recibos")
public class Recibo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recibos_id_gen")
    @SequenceGenerator(name = "recibos_id_gen", sequenceName = "recibos_cod_recibo_seq", allocationSize = 1)
    @Column(name = "cod_recibo", nullable = false)
    private Integer id;

    @Column(name = "numerorecibo", length = 50)
    private String numerorecibo;

    @Column(name = "descricao", length = Integer.MAX_VALUE)
    private String descricao;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "valorunitario", precision = 10, scale = 2)
    private BigDecimal valorunitario;

    @Column(name = "valortotal", precision = 10, scale = 2)
    private BigDecimal valortotal;

    @Column(name = "dataemissao")
    private LocalDate dataemissao;

    @Column(name = "dtpagamento")
    private LocalDate dtpagamento;

    @Column(name = "observacoes", length = Integer.MAX_VALUE)
    private String observacoes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fatura")
    private Fatura idFatura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fornecedores")
    private Fornecedore idFornecedores;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_metodo")
    private Metodopagamento idMetodo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumerorecibo() {
        return numerorecibo;
    }

    public void setNumerorecibo(String numerorecibo) {
        this.numerorecibo = numerorecibo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(BigDecimal valorunitario) {
        this.valorunitario = valorunitario;
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        this.valortotal = valortotal;
    }

    public LocalDate getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(LocalDate dataemissao) {
        this.dataemissao = dataemissao;
    }

    public LocalDate getDtpagamento() {
        return dtpagamento;
    }

    public void setDtpagamento(LocalDate dtpagamento) {
        this.dtpagamento = dtpagamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Fatura getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(Fatura idFatura) {
        this.idFatura = idFatura;
    }

    public Fornecedore getIdFornecedores() {
        return idFornecedores;
    }

    public void setIdFornecedores(Fornecedore idFornecedores) {
        this.idFornecedores = idFornecedores;
    }

    public Metodopagamento getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(Metodopagamento idMetodo) {
        this.idMetodo = idMetodo;
    }

}