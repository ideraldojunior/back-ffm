package com.fixforme.telacontratante.repository;

import com.fixforme.telacontratante.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

    List<Servico> findByPrestadorId(Long idPrestador);
}