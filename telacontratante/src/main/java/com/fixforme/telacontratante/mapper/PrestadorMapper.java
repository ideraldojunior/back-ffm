package com.fixforme.telacontratante.mapper;

import com.fixforme.telacontratante.dto.PrestadorResponseDTO;
import com.fixforme.telacontratante.model.Prestador;
import com.fixforme.telacontratante.model.PrestadorEspecializacao;

import java.util.List;
import java.util.stream.Collectors;

public class PrestadorMapper {

    public static PrestadorResponseDTO toDTO(Prestador prestador) {
        List<String> nomesEspecializacoes = prestador.getEspecializacoes().stream()
                .map(pe -> pe.getEspecializacao().getNome())
                .collect(Collectors.toList());

        return new PrestadorResponseDTO(
                prestador.getId(),
                prestador.getNome(),
                prestador.getEmail(),
                prestador.getAvaliacao(),
                nomesEspecializacoes
        );
    }
}