package com.example.core.models;

import jakarta.persistence.*;

@Entity
@Table(name = "funcionariosfixos")
public class Funcionariosfixo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private Integer id;

    private String nome;
    private String contacto;

    @ManyToOne
    @JoinColumn(name = "id_funcao")
    private Funcaofuncionario funcao;

    @OneToOne(mappedBy = "idFuncionario") // <- RELAÇÃO INVERSA CORRETA
    private Utilizador utilizador;

    // Getters e Setters

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getContacto() { return contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }

    public Funcaofuncionario getFuncao() { return funcao; }
    public void setFuncao(Funcaofuncionario funcao) { this.funcao = funcao; }

    public Utilizador getUtilizador() { return utilizador; }
    public void setUtilizador(Utilizador utilizador) { this.utilizador = utilizador; }
}
