package com.example.projetoii_dados.DTOs;

public class UtilizadorDTO {
    private String nome;
    private String username;
    private String contacto;
    private Integer idCliente;
    private Integer idFuncionario;
    private Integer idTipouser;

    public UtilizadorDTO() {}

    public UtilizadorDTO(String nome, String username, String contacto, Integer idCliente, Integer idFuncionario, Integer idTipouser) {
        this.nome = nome;
        this.username = username;
        this.contacto = contacto;
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
        this.idTipouser = idTipouser;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getContacto() { return contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }

    public Integer getIdCliente() { return idCliente; }
    public void setIdCliente(Integer idCliente) { this.idCliente = idCliente; }

    public Integer getIdFuncionario() { return idFuncionario; }
    public void setIdFuncionario(Integer idFuncionario) { this.idFuncionario = idFuncionario; }

    public Integer getIdTipouser() { return idTipouser; }
    public void setIdTipouser(Integer idTipouser) { this.idTipouser = idTipouser; }
}
