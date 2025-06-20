package com.example.projetoii_dados.DTOs;

public class TipoServicoDTO {
    private Integer id;
    private String designacao;

    public TipoServicoDTO() {}

    public TipoServicoDTO(Integer id, String designacao) {
        this.id = id;
        this.designacao = designacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
}
