package com.example.projetoii_dados.DTOs;

public class TipoUtilizadorDTO {
    private String designacao;

    public TipoUtilizadorDTO() {}

    public TipoUtilizadorDTO(String designacao) {
        this.designacao = designacao;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
}
