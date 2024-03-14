package com.FiapTravel.controller;

import com.FiapTravel.model.TipoQuarto;
import com.FiapTravel.service.TipoQuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/tiposquartos")
public class TipoQuartoController {
    private final TipoQuartoService tipoQuartoService;
    @Autowired
    public TipoQuartoController(TipoQuartoService tipoQuartoService) {
        this.tipoQuartoService = tipoQuartoService;
    }

    @PostMapping
    public ResponseEntity<TipoQuarto> criarTipoQuarto(@RequestBody TipoQuarto tipoQuarto) {
        TipoQuarto novoTipoQuarto = tipoQuartoService.save(tipoQuarto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTipoQuarto);
    }

    @GetMapping
    public ResponseEntity<List<TipoQuarto>> buscarTodosTiposQuartos() {
        List<TipoQuarto> tiposQuartos = tipoQuartoService.buscarTodosTiposQuartos();
        return ResponseEntity.ok(tiposQuartos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoQuarto> buscarPorId(@PathVariable UUID id) {
        Optional<TipoQuarto> tipoQuartoOptional = tipoQuartoService.buscarPorId(id);
        return tipoQuartoOptional.map(tipoQuarto -> ResponseEntity.ok().body(tipoQuarto))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoQuarto> atualizarTipoQuarto(@PathVariable UUID id, @RequestBody TipoQuarto tipoQuarto) {
        TipoQuarto tipoQuartoAtualizado = tipoQuartoService.atualizarTipoQuarto(id, tipoQuarto);
        if (tipoQuartoAtualizado != null) {
            return ResponseEntity.ok(tipoQuartoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTipoQuarto(@PathVariable UUID id) {
        tipoQuartoService.deletarTipoQuarto(id);
        return ResponseEntity.noContent().build();
    }
}