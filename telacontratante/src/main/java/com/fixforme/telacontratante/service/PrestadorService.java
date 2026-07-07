package com.fixforme.telacontratante.service;

import com.fixforme.telacontratante.dto.PrestadorRequestDTO;
import com.fixforme.telacontratante.dto.PrestadorResponseDTO;
import com.fixforme.telacontratante.mapper.PrestadorMapper;
import com.fixforme.telacontratante.model.Prestador;
import com.fixforme.telacontratante.repository.PrestadorRepository;
import com.fixforme.telacontratante.strategy.BuscaPorEspecializacaoStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestadorService {

    private final PrestadorRepository prestadorRepository;
    private final BuscaPorEspecializacaoStrategy buscaStrategy;

    public PrestadorService(PrestadorRepository prestadorRepository,
                             BuscaPorEspecializacaoStrategy buscaStrategy) {
        this.prestadorRepository = prestadorRepository;
        this.buscaStrategy = buscaStrategy;
    }

    // ---------- READ ----------

    public List<Prestador> buscarPorServico(String descricaoServico) {
        return buscaStrategy.buscar(descricaoServico);
    }

    public Optional<Prestador> buscarPorId(Long id) {
        return prestadorRepository.findById(id);
    }

    public List<Prestador> listarTodos() {
        return prestadorRepository.findAll();
    }

    // ---------- CREATE ----------

    public PrestadorResponseDTO criar(PrestadorRequestDTO dto) {
        Prestador prestador = new Prestador();
        prestador.setNome(dto.nome());
        prestador.setEmail(dto.email());
        prestador.setAvaliacao(0.0); // prestador novo começa sem avaliação

        Prestador salvo = prestadorRepository.save(prestador);
        return PrestadorMapper.toDTO(salvo);
    }

    // ---------- UPDATE ----------

    public Optional<PrestadorResponseDTO> atualizar(Long id, PrestadorRequestDTO dto) {
        return prestadorRepository.findById(id)
                .map(prestador -> {
                    prestador.setNome(dto.nome());
                    prestador.setEmail(dto.email());
                    Prestador atualizado = prestadorRepository.save(prestador);
                    return PrestadorMapper.toDTO(atualizado);
                });
    }

    // ---------- DELETE ----------

    public boolean deletar(Long id) {
        if (!prestadorRepository.existsById(id)) {
            return false;
        }
        prestadorRepository.deleteById(id);
        return true;
    }
}