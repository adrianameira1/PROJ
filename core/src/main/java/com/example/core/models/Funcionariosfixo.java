package com.example.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "funcionariosfixos")
public class Funcionariosfixo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionariosfixos_id_gen")
    @SequenceGenerator(name = "funcionariosfixos_id_gen", sequenceName = "funcionariosfixos_id_funcionario_seq", allocationSize = 1)
    @Column(name = "id_funcionario", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "contacto", length = 100)
    private String contacto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_funcao", nullable = false)
    private Funcaofuncionario idFuncao;

    @ManyToMany(mappedBy = "funcionariosfixos")
    private Set<Evento> eventos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idFuncionario")
    @JsonIgnore
    private Set<Utilizador> utilizadors = new LinkedHashSet<>();

    // Getters e setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Funcaofuncionario getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(Funcaofuncionario idFuncao) {
        this.idFuncao = idFuncao;
    }

    public Set<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Set<Evento> eventos) {
        this.eventos = eventos;
    }

    public Set<Utilizador> getUtilizadors() {
        return utilizadors;
    }

    public void setUtilizadors(Set<Utilizador> utilizadors) {
        this.utilizadors = utilizadors;
    }
}
