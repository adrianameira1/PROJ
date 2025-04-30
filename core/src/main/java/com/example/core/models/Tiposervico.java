package com.example.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tiposervico")
public class Tiposervico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tiposervico_id_gen")
    @SequenceGenerator(name = "tiposervico_id_gen", sequenceName = "tiposervico_id_tiposervico_seq", allocationSize = 1)
    @Column(name = "id_tiposervico", nullable = false)
    private Integer id;

    @Column(name = "designacao", nullable = false, length = 100)
    private String designacao;

    @JsonIgnore
    @OneToMany(mappedBy = "idTiposervico")
    private Set<Servico> servicos = new LinkedHashSet<>();

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

    public Set<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(Set<Servico> servicos) {
        this.servicos = servicos;
    }

}