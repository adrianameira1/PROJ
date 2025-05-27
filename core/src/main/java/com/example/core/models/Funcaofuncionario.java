package com.example.core.models;

import jakarta.persistence.*;

@Entity
@Table(name = "funcaofuncionario")
public class Funcaofuncionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcao")
    private Integer idFuncao;

    @Column(name = "designacao")
    private String designacao;

    public Integer getId() {
        return idFuncao;
    }

    public void setId(Integer id) {
        this.idFuncao = id;
    }

    public Integer getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(Integer idFuncao) {
        this.idFuncao = idFuncao;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
}
