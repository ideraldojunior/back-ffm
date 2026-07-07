package com.fixforme.telacontratante.strategy;

import com.fixforme.telacontratante.model.Prestador;
import java.util.List;

public interface BuscaPrestadorStrategy {
    List<Prestador> buscar(String criterio);
}