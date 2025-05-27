package com.example.projetoii_dados.DTOs;

public class TipoFaturaDTO {
    private String designacao;

    public TipoFaturaDTO() {}

    public TipoFaturaDTO(String designacao) {
        this.designacao = designacao;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
}
