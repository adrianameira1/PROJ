package com.example.projetoii_dados.DTOs;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReciboDTO {
    private String numerorecibo;
    private String descricao;
    private Integer quantidade;
    private BigDecimal valorunitario;
    private BigDecimal valortotal;
    private LocalDate dataemissao;
    private LocalDate dtpagamento;
    private String observacoes;
    private Integer idEvento;
    private Integer idMetodoPagamento;

    public ReciboDTO() {}

    public ReciboDTO(String numerorecibo, String descricao, Integer quantidade, BigDecimal valorunitario,
                     BigDecimal valortotal, LocalDate dataemissao, LocalDate dtpagamento,
                     String observacoes, Integer idEvento, Integer idMetodoPagamento) {
        this.numerorecibo = numerorecibo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorunitario = valorunitario;
        this.valortotal = valortotal;
        this.dataemissao = dataemissao;
        this.dtpagamento = dtpagamento;
        this.observacoes = observacoes;
        this.idEvento = idEvento;
        this.idMetodoPagamento = idMetodoPagamento;
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

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Integer getIdMetodoPagamento() {
        return idMetodoPagamento;
    }

    public void setIdMetodoPagamento(Integer idMetodoPagamento) {
        this.idMetodoPagamento = idMetodoPagamento;
    }
}
