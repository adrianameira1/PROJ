package com.example.projetoii_dados.DTOs;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FaturaDTO {
    private BigDecimal valor;
    private LocalDate dtemissao;
    private String status;
    private LocalDate dtpagamento;
    private Integer idEvento;
    private Integer idTipofatura;

    public FaturaDTO() {}

    public FaturaDTO(BigDecimal valor, LocalDate dtemissao, String status,
                     LocalDate dtpagamento, Integer idEvento, Integer idTipofatura) {
        this.valor = valor;
        this.dtemissao = dtemissao;
        this.status = status;
        this.dtpagamento = dtpagamento;
        this.idEvento = idEvento;
        this.idTipofatura = idTipofatura;
    }

    // Getters e Setters
    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public LocalDate getDtemissao() { return dtemissao; }
    public void setDtemissao(LocalDate dtemissao) { this.dtemissao = dtemissao; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getDtpagamento() { return dtpagamento; }
    public void setDtpagamento(LocalDate dtpagamento) { this.dtpagamento = dtpagamento; }

    public Integer getIdEvento() { return idEvento; }
    public void setIdEvento(Integer idEvento) { this.idEvento = idEvento; }

    public Integer getIdTipofatura() { return idTipofatura; }
    public void setIdTipofatura(Integer idTipofatura) { this.idTipofatura = idTipofatura; }
}
