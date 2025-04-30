package com.example.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipoevento")
public class Tipoevento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipoevento_id_gen")
    @SequenceGenerator(name = "tipoevento_id_gen", sequenceName = "tipoevento_id_tipoevento_seq", allocationSize = 1)
    @Column(name = "id_tipoevento", nullable = false)
    private Integer id;

    @Column(name = "designacao", nullable = false, length = 100)
    private String designacao;

    @JsonIgnore
    @OneToMany(mappedBy = "idTipoevento")
    private Set<Evento> eventos = new LinkedHashSet<>();

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

    public Set<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Set<Evento> eventos) {
        this.eventos = eventos;
    }

}