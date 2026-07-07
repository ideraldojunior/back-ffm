package com.fixforme.telacontratante.repository;

import com.fixforme.telacontratante.model.Prestador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrestadorRepository extends JpaRepository<Prestador, Long> {

    // busca prestadores cuja especialização bate com o termo digitado pelo contratante
    List<Prestador> findByEspecializacoes_Especializacao_NomeContainingIgnoreCase(String nomeEspecializacao);
}