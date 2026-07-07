package com.fixforme.telacontratante.controller;

import com.fixforme.telacontratante.dto.PrestadorRequestDTO;
import com.fixforme.telacontratante.dto.PrestadorResponseDTO;
import com.fixforme.telacontratante.dto.PropostaRequestDTO;
import com.fixforme.telacontratante.dto.ServicoResponseDTO;
import com.fixforme.telacontratante.mapper.PrestadorMapper;
import com.fixforme.telacontratante.model.Servico;
import com.fixforme.telacontratante.service.PrestadorService;
import com.fixforme.telacontratante.service.ServicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestadores")
@CrossOrigin(origins = "*") // em produção, trocar "*" pela URL real do front (Expo/Next)
public class PrestadorController {

    private final PrestadorService prestadorService;
    private final ServicoService servicoService;

    public PrestadorController(PrestadorService prestadorService, ServicoService servicoService) {
        this.prestadorService = prestadorService;
        this.servicoService = servicoService;
    }

    // ---------- GET: listar todos ----------
    @GetMapping
    public ResponseEntity<List<PrestadorResponseDTO>> listarTodos() {
        List<PrestadorResponseDTO> lista = prestadorService.listarTodos().stream()
                .map(PrestadorMapper::toDTO)
                .toList();
        return ResponseEntity.ok(lista);
    }

    // ---------- GET: buscar prestadores por serviço/especialização ----------
    @GetMapping("/buscar")
    public ResponseEntity<List<PrestadorResponseDTO>> buscarPorServico(@RequestParam String descricao) {
        List<PrestadorResponseDTO> resultado = prestadorService.buscarPorServico(descricao).stream()
                .map(PrestadorMapper::toDTO)
                .toList();
        return ResponseEntity.ok(resultado);
    }

    // ---------- GET: abrir perfil de um prestador ----------
    @GetMapping("/{id}")
    public ResponseEntity<PrestadorResponseDTO> buscarPorId(@PathVariable Long id) {
        return prestadorService.buscarPorId(id)
                .map(PrestadorMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ---------- POST: criar prestador ----------
    @PostMapping
    public ResponseEntity<PrestadorResponseDTO> criar(@RequestBody PrestadorRequestDTO dto) {
        PrestadorResponseDTO criado = prestadorService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    // ---------- PUT: atualizar prestador ----------
    @PutMapping("/{id}")
    public ResponseEntity<PrestadorResponseDTO> atualizar(@PathVariable Long id,
                                                           @RequestBody PrestadorRequestDTO dto) {
        return prestadorService.atualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ---------- DELETE: remover prestador ----------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removido = prestadorService.deletar(id);
        return removido ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // ---------- POST: contratante envia proposta pro prestador escolhido ----------
    @PostMapping("/{id}/proposta")
    public ResponseEntity<ServicoResponseDTO> enviarProposta(@PathVariable Long id,
                                                              @RequestBody PropostaRequestDTO dto) {
        Servico servico = servicoService.enviarProposta(id, dto.descricao(), dto.valor());
        ServicoResponseDTO response = new ServicoResponseDTO(
                servico.getId(), servico.getDescricao(), servico.getValor(), id
        );
        return ResponseEntity.ok(response);
    }
}