package com.example.projetoii_dados.DTOs;

public class ServicoFornecedorDTO {
    private Integer idServico;
    private Integer idFornecedor;

    public ServicoFornecedorDTO() {}

    public ServicoFornecedorDTO(Integer idServico, Integer idFornecedor) {
        this.idServico = idServico;
        this.idFornecedor = idFornecedor;
    }

    public Integer getIdServico() { return idServico; }
    public void setIdServico(Integer idServico) { this.idServico = idServico; }

    public Integer getIdFornecedor() { return idFornecedor; }
    public void setIdFornecedor(Integer idFornecedor) { this.idFornecedor = idFornecedor; }
}

