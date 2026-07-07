package com.fixforme.telacontratante.dto;

import java.util.List;

public class PrestadorResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private Double avaliacao;
    private List<String> especializacoes;

    public PrestadorResponseDTO(Long id, String nome, String email, Double avaliacao, List<String> especializacoes) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.avaliacao = avaliacao;
        this.especializacoes = especializacoes;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public Double getAvaliacao() { return avaliacao; }
    public List<String> getEspecializacoes() { return especializacoes; }
}