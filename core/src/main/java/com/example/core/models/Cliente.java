package com.example.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_id_gen")
    @SequenceGenerator(name = "cliente_id_gen", sequenceName = "cliente_id_cliente_seq", allocationSize = 1)
    @Column(name = "id_cliente", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "telefone", length = 15)
    private String telefone;

    @JsonIgnore
    @OneToMany(mappedBy = "idCliente")
    private Set<Reserva> reservas = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "idCliente")
    private Set<Utilizador> utilizadors = new LinkedHashSet<>();

    public Cliente() {
    }

    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Set<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Set<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Set<Utilizador> getUtilizadors() {
        return utilizadors;
    }

    public void setUtilizadors(Set<Utilizador> utilizadors) {
        this.utilizadors = utilizadors;
    }
}
