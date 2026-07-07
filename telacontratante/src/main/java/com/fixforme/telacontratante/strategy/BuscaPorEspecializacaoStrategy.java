package com.fixforme.telacontratante.strategy;

import com.fixforme.telacontratante.model.Prestador;
import com.fixforme.telacontratante.repository.PrestadorRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuscaPorEspecializacaoStrategy implements BuscaPrestadorStrategy {

    private final PrestadorRepository prestadorRepository;

    public BuscaPorEspecializacaoStrategy(PrestadorRepository prestadorRepository) {
        this.prestadorRepository = prestadorRepository;
    }

    @Override
    public List<Prestador> buscar(String criterio) {
        return prestadorRepository.findByEspecializacoes_Especializacao_NomeContainingIgnoreCase(criterio);
    }
}