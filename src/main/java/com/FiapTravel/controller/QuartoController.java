package com.FiapTravel.controller;

import com.FiapTravel.model.Quarto;
import com.FiapTravel.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/quartos")
public class QuartoController {
    private final QuartoService quartoService;
    @Autowired
    public QuartoController(QuartoService quartoService) {
        this.quartoService = quartoService;
    }

    @PostMapping
    public ResponseEntity<Quarto> criarQuarto(@RequestBody Quarto quarto) {
        Quarto novoQuarto = quartoService.save(quarto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoQuarto);
    }

    @GetMapping
    public ResponseEntity<List<Quarto>> buscarTodosQuartos() {
        List<Quarto> quartos = quartoService.buscarTodosQuartos();
        return ResponseEntity.ok(quartos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quarto> buscarPorId(@PathVariable UUID id) {
        Optional<Quarto> quartoOptional = quartoService.buscarPorId(id);
        return quartoOptional.map(quarto -> ResponseEntity.ok().body(quarto))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quarto> atualizarQuarto(@PathVariable UUID id, @RequestBody Quarto quarto) {
        Quarto quartoAtualizado = quartoService.atualizarQuarto(id, quarto);
        if (quartoAtualizado != null) {
            return ResponseEntity.ok(quartoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarQuarto(@PathVariable UUID id) {
        quartoService.deletarQuarto(id);
        return ResponseEntity.noContent().build();
    }
}