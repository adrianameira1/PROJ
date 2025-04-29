package com.backoffice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Utilizador {
    private Integer id;
    private String nome;
    private String username;
    private TipoUtilizador idTipouser;

    public Integer getId() { return id; }
    public String getNome() { return nome; }
    public String getUsername() { return username; }
    public TipoUtilizador getIdTipouser() { return idTipouser; }
}

