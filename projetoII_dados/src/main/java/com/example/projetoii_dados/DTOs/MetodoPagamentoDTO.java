package com.example.projetoii_dados.DTOs;

public class MetodoPagamentoDTO {
    private String designacao;

    public MetodoPagamentoDTO() {}

    public MetodoPagamentoDTO(String designacao) {
        this.designacao = designacao;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
}
