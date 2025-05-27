package com.example.projetoii_dados.DTOs;

public class FuncaoFuncionarioDTO {
    private String designacao;

    public FuncaoFuncionarioDTO() {}

    public FuncaoFuncionarioDTO(String designacao) {
        this.designacao = designacao;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
}
