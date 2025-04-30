package com.example.core.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "funcaofuncionario")
public class Funcaofuncionario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcaofuncionario_id_gen")
    @SequenceGenerator(name = "funcaofuncionario_id_gen", sequenceName = "funcaofuncionario_id_funcao_seq", allocationSize = 1)
    @Column(name = "id_funcao", nullable = false)
    private Integer id;

    @Column(name = "designacao", nullable = false, length = 100)
    private String designacao;

    @OneToMany(mappedBy = "idFuncao")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Set<Funcionariosfixo> funcionariosfixos = new LinkedHashSet<>();

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

    public Set<Funcionariosfixo> getFuncionariosfixos() {
        return funcionariosfixos;
    }

    public void setFuncionariosfixos(Set<Funcionariosfixo> funcionariosfixos) {
        this.funcionariosfixos = funcionariosfixos;
    }

}