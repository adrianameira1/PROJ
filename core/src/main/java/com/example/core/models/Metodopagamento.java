package com.example.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "metodopagamento")
public class Metodopagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "metodopagamento_id_gen")
    @SequenceGenerator(name = "metodopagamento_id_gen",
            sequenceName = "metodopagamento_id_metodo_seq",
            allocationSize = 1)
    @Column(name = "id_metodo", nullable = false)
    private Integer id;

    @Column(name = "designacao", nullable = false, length = 100)
    private String designacao;

    /** Recibos que usam este método de pagamento */
    @JsonIgnore
    @OneToMany(mappedBy = "idMetodoPagamento")   // <-- ajustado
    private Set<Recibo> recibos = new LinkedHashSet<>();

    /* ---------- getters / setters ---------- */

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getDesignacao() { return designacao; }
    public void setDesignacao(String designacao) { this.designacao = designacao; }

    public Set<Recibo> getRecibos() { return recibos; }
    public void setRecibos(Set<Recibo> recibos) { this.recibos = recibos; }
}
