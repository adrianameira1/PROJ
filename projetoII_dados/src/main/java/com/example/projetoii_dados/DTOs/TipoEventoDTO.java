package com.example.projetoii_dados.DTOs;

public class TipoEventoDTO {
    private String designacao;

    public TipoEventoDTO() {}

    public TipoEventoDTO(String designacao) {
        this.designacao = designacao;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
}
