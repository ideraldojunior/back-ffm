package com.fixforme.telacontratante.model;

import jakarta.persistence.*;

@Entity
@Table(name = "prestador_especializacao")
public class PrestadorEspecializacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prestador", nullable = false)
    private Prestador prestador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_especializacao", nullable = false)
    private Especializacao especializacao;

    public PrestadorEspecializacao() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Prestador getPrestador() { return prestador; }
    public void setPrestador(Prestador prestador) { this.prestador = prestador; }

    public Especializacao getEspecializacao() { return especializacao; }
    public void setEspecializacao(Especializacao especializacao) { this.especializacao = especializacao; }
}