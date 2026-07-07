package com.fixforme.telacontratante.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private BigDecimal valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prestador", nullable = false)
    private Prestador prestador;

    public Servico() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public Prestador getPrestador() { return prestador; }
    public void setPrestador(Prestador prestador) { this.prestador = prestador; }
}