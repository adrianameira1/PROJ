package com.example.core.models;

import jakarta.persistence.*;

@Entity
@Table(name = "utilizador")
public class Utilizador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String nome;

    private String username;

    @Column(name = "password_hash")
    private String passwordHash;

    @ManyToOne
    @JoinColumn(name = "id_tipouser")
    private Tipoutilizador idTipouser;

    @OneToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionariosfixo idFuncionario;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente idCliente;

    // ✅ GETTERS e SETTERS

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

    public Tipoutilizador getIdTipouser() {
        return idTipouser;
    }

    public void setIdTipouser(Tipoutilizador idTipouser) {
        this.idTipouser = idTipouser;
    }

    public Funcionariosfixo getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionariosfixo idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }
}
