package com.example.core.models;

import jakarta.persistence.*;

@Entity
@Table(name = "servico_fornecedor")
public class ServicoFornecedor {
    @SequenceGenerator(name = "servico_fornecedor_id_gen", sequenceName = "servico_id_servico_seq", allocationSize = 1)
    @EmbeddedId
    private ServicoFornecedorId id;

    @MapsId("idFornecedor")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_fornecedor", nullable = false)
    private Fornecedore idFornecedor;

    @MapsId("idServico")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_servico", nullable = false)
    private Servico idServico;

    public ServicoFornecedorId getId() {
        return id;
    }

    public void setId(ServicoFornecedorId id) {
        this.id = id;
    }

    public Fornecedore getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Fornecedore idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Servico getIdServico() {
        return idServico;
    }

    public void setIdServico(Servico idServico) {
        this.idServico = idServico;
    }

}