package com.backoffice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Utilizador {
    private Integer id;
    private String nome;
    private String username;
    private Integer idTipouser;

    public Integer getId() { return id; }
    public String getNome() { return nome; }
    public String getUsername() { return username; }
    public Integer getIdTipouser() { return idTipouser; }

    public void setIdTipouser(Integer idTipouser) {
        this.idTipouser = idTipouser;
    }
}
