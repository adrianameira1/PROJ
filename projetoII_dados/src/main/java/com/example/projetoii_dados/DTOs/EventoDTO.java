package com.example.projetoii_dados.DTOs;

import java.math.BigDecimal;

public class EventoDTO {
    private Integer id; // 🔧 Necessário para editar
    private BigDecimal orcamento;
    private String cronograma;
    private String statusevento;
    private Integer idReserva;
    private Integer idTipoevento;

    public EventoDTO() {}

    // ✅ Construtor completo com ID
    public EventoDTO(Integer id, BigDecimal orcamento, String cronograma, String statusevento,
                     Integer idReserva, Integer idTipoevento) {
        this.id = id;
        this.orcamento = orcamento;
        this.cronograma = cronograma;
        this.statusevento = statusevento;
        this.idReserva = idReserva;
        this.idTipoevento = idTipoevento;
    }

    // ✅ Construtor sem ID (útil para criação)
    public EventoDTO(BigDecimal orcamento, String cronograma, String statusevento,
                     Integer idReserva, Integer idTipoevento) {
        this.orcamento = orcamento;
        this.cronograma = cronograma;
        this.statusevento = statusevento;
        this.idReserva = idReserva;
        this.idTipoevento = idTipoevento;
    }

    // ✅ Getters e Setters
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

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Integer getIdTipoevento() {
        return idTipoevento;
    }

    public void setIdTipoevento(Integer idTipoevento) {
        this.idTipoevento = idTipoevento;
    }
}
