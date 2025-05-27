package com.example.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipofatura")
public class Tipofatura {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipofatura_id_gen")
    @SequenceGenerator(name = "tipofatura_id_gen", sequenceName = "tipofatura_id_tipofatura_seq", allocationSize = 1)
    @Column(name = "id_tipofatura", nullable = false)
    private Integer id;

    @Column(name = "designacao", nullable = false, length = 100)
    private String designacao;

    @JsonIgnore
    @OneToMany(mappedBy = "idTipofatura")
    private Set<Fatura> faturas = new LinkedHashSet<>();

    // Construtor vazio obrigatório para JPA e Swagger
    public Tipofatura() {}

    // Construtor opcional
    public Tipofatura(String designacao) {
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

    public Set<Fatura> getFaturas() {
        return faturas;
    }

    public void setFaturas(Set<Fatura> faturas) {
        this.faturas = faturas;
    }
}
