package com.FiapTravel.controller;

import com.FiapTravel.model.Empreendimento;
import com.FiapTravel.service.EmpreendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/empreendimentos")
public class EmpreendimentoController {
    private final EmpreendimentoService empreendimentoService;
    @Autowired
    public EmpreendimentoController(EmpreendimentoService empreendimentoService) {
        this.empreendimentoService = empreendimentoService;
    }

    @PostMapping
    public ResponseEntity<Empreendimento> criarEmpreendimento(@RequestBody Empreendimento empreendimento) {
        Empreendimento novoEmpreendimento = empreendimentoService.save(empreendimento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEmpreendimento);
    }

    @GetMapping
    public ResponseEntity<List<Empreendimento>> buscarTodosEmpreendimentos() {
        List<Empreendimento> empreendimentos = empreendimentoService.buscarTodosEmpreendimentos();
        return ResponseEntity.ok(empreendimentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empreendimento> buscarPorId(@PathVariable UUID id) {
        Optional<Empreendimento> empreendimentoOptional = empreendimentoService.buscarPorId(id);
        return empreendimentoOptional.map(empreendimento -> ResponseEntity.ok().body(empreendimento))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empreendimento> atualizarEmpreendimento(@PathVariable UUID id,
                                                                  @RequestBody Empreendimento empreendimento) {
        Empreendimento empreendimentoAtualizado =
                empreendimentoService.atualizarEmpreendimento(id, empreendimento);
        if (empreendimentoAtualizado != null) {
            return ResponseEntity.ok(empreendimentoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmpreendimento(@PathVariable UUID id) {
        empreendimentoService.deletarEmpreendimento(id);
        return ResponseEntity.noContent().build();
    }
}
