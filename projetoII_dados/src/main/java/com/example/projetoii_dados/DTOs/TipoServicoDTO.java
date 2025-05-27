package com.example.projetoii_dados.DTOs;

public class TipoServicoDTO {
    private String designacao;

    public TipoServicoDTO() {}

    public TipoServicoDTO(String designacao) {
        this.designacao = designacao;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
}
