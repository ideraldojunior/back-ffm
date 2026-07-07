package com.fixforme.telacontratante.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "prestador")
public class Prestador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    private Double avaliacao;

    @OneToMany(mappedBy = "prestador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PrestadorEspecializacao> especializacoes = new ArrayList<>();

    @OneToMany(mappedBy = "prestador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Servico> servicos = new ArrayList<>();

    public Prestador() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Double getAvaliacao() { return avaliacao; }
    public void setAvaliacao(Double avaliacao) { this.avaliacao = avaliacao; }

    public List<PrestadorEspecializacao> getEspecializacoes() { return especializacoes; }
    public void setEspecializacoes(List<PrestadorEspecializacao> especializacoes) { this.especializacoes = especializacoes; }

    public List<Servico> getServicos() { return servicos; }
    public void setServicos(List<Servico> servicos) { this.servicos = servicos; }
}