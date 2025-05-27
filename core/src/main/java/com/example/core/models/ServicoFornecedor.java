package com.example.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "servico_fornecedor")
public class ServicoFornecedor {
    @SequenceGenerator(name = "servico_fornecedor_id_gen", sequenceName = "servico_id_servico_seq", allocationSize = 1)
    @EmbeddedId
    private ServicoFornecedorId id;

    @JsonIgnore
    @MapsId("idFornecedor")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_fornecedor", nullable = false)
    private Fornecedor idFornecedor;

    @JsonIgnore
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

    public Fornecedor getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Fornecedor idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Servico getIdServico() {
        return idServico;
    }

    public void setIdServico(Servico idServico) {
        this.idServico = idServico;
    }

}