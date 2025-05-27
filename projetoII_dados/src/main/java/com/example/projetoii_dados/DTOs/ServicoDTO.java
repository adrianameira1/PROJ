package com.example.projetoii_dados.DTOs;

import java.math.BigDecimal;

public class ServicoDTO {
    private String statuspagamento;
    private String detalhesservico;
    private BigDecimal custototal;
    private Integer idEvento;
    private Integer idTiposervico;

    public ServicoDTO() {}

    public ServicoDTO(String statuspagamento, String detalhesservico, BigDecimal custototal,
                      Integer idEvento, Integer idTiposervico) {
        this.statuspagamento = statuspagamento;
        this.detalhesservico = detalhesservico;
        this.custototal = custototal;
        this.idEvento = idEvento;
        this.idTiposervico = idTiposervico;
    }

    public String getStatuspagamento() { return statuspagamento; }
    public void setStatuspagamento(String statuspagamento) { this.statuspagamento = statuspagamento; }

    public String getDetalhesservico() { return detalhesservico; }
    public void setDetalhesservico(String detalhesservico) { this.detalhesservico = detalhesservico; }

    public BigDecimal getCustototal() { return custototal; }
    public void setCustototal(BigDecimal custototal) { this.custototal = custototal; }

    public Integer getIdEvento() { return idEvento; }
    public void setIdEvento(Integer idEvento) { this.idEvento = idEvento; }

    public Integer getIdTiposervico() { return idTiposervico; }
    public void setIdTiposervico(Integer idTiposervico) { this.idTiposervico = idTiposervico; }
}
