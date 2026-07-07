package com.fixforme.telacontratante.dto;

import java.math.BigDecimal;

public record ServicoResponseDTO(Long id, String descricao, BigDecimal valor, Long idPrestador) {}