package com.example.projetoii_dados.DTOs;

import java.math.BigDecimal;

public class EventoDTO {
    private BigDecimal orcamento;
    private String cronograma;
    private String statusevento;
    private Integer idReserva;
    private Integer idTipoevento;

    public EventoDTO() {}

    public EventoDTO(BigDecimal orcamento, String cronograma, String statusevento,
                     Integer idReserva, Integer idTipoevento) {
        this.orcamento = orcamento;
        this.cronograma = cronograma;
        this.statusevento = statusevento;
        this.idReserva = idReserva;
        this.idTipoevento = idTipoevento;
    }

   public BigDecimal getOrcamento(){
        return orcamento;
    }
    public String getCronograma(){
        return cronograma;
    }
    public String getStatusevento(){
        return statusevento;
    }
    public Integer getIdReserva(){
        return idReserva;
    }
    public Integer getIdTipoevento(){
        return idTipoevento;
    }
}
