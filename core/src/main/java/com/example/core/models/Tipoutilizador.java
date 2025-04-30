package com.example.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipoutilizador")
public class Tipoutilizador {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipoutilizador_id_gen")
    @SequenceGenerator(name = "tipoutilizador_id_gen", sequenceName = "tipoutilizador_id_tipouser_seq", allocationSize = 1)
    @Column(name = "id_tipouser", nullable = false)
    private Integer id;

    @Column(name = "designacao", nullable = false, length = 100)
    private String designacao;

    @JsonIgnore
    @OneToMany(mappedBy = "idTipouser")
    private Set<Utilizador> utilizadors = new LinkedHashSet<>();

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

    public Set<Utilizador> getUtilizadors() {
        return utilizadors;
    }

    public void setUtilizadors(Set<Utilizador> utilizadors) {
        this.utilizadors = utilizadors;
    }

}