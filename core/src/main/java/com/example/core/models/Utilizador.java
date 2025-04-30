package com.example.core.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "utilizador")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Utilizador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utilizador_id_gen")
    @SequenceGenerator(name = "utilizador_id_gen", sequenceName = "utilizador_id_user_seq", allocationSize = 1)
    @Column(name = "id_user", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password_hash", length = 100)
    private String passwordHash;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    @JsonIgnore
    private Cliente idCliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_funcionario")
    @JsonIgnore
    private Funcionariosfixo idFuncionario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipouser", nullable = false)
    @JsonIgnore
    private Tipoutilizador idTipouser;

    // Construtor vazio
    public Utilizador() {}

    // Getters e Setters
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Funcionariosfixo getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionariosfixo idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Tipoutilizador getIdTipouser() {
        return idTipouser;
    }

    public void setIdTipouser(Tipoutilizador idTipouser) {
        this.idTipouser = idTipouser;
    }
}
