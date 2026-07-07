package com.fixforme.telacontratante.service;

import com.fixforme.telacontratante.model.Prestador;
import com.fixforme.telacontratante.model.Servico;
import com.fixforme.telacontratante.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;
    private final PrestadorService prestadorService;

    @Autowired
    public ServicoService(ServicoRepository servicoRepository, PrestadorService prestadorService) {
        this.servicoRepository = servicoRepository;
        this.prestadorService = prestadorService;
    }

    public Servico enviarProposta(Long idPrestador, String descricao, BigDecimal valor) {
        Prestador prestador = prestadorService.buscarPorId(idPrestador)
                .orElseThrow(() -> new IllegalArgumentException("Prestador não encontrado: " + idPrestador));

        Servico servico = new Servico();
        servico.setDescricao(descricao);
        servico.setValor(valor);
        servico.setPrestador(prestador);

        return servicoRepository.save(servico);
    }
}