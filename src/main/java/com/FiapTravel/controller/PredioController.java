package com.FiapTravel.controller;

import com.FiapTravel.model.Predio;
import com.FiapTravel.services.PredioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/predios")
public class PredioController {
    private final PredioService predioService;
    @Autowired
    public PredioController(PredioService predioService) {
        this.predioService = predioService;
    }

    @PostMapping
    public ResponseEntity<Predio> criarPredio(@RequestBody Predio predio) {
        Predio novoPredio = predioService.save(predio);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPredio);
    }

    @GetMapping
    public ResponseEntity<List<Predio>> buscarTodosPredios() {
        List<Predio> predios = predioService.buscarTodosPredios();
        return ResponseEntity.ok(predios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Predio> buscarPorId(@PathVariable UUID id) {
        Optional<Predio> predioOptional = predioService.buscarPorId(id);
        return predioOptional.map(predio -> ResponseEntity.ok().body(predio))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Predio> atualizarPredio(@PathVariable UUID id, @RequestBody Predio predio) {
        Predio predioAtualizado = predioService.atualizarPredio(id, predio);
        if (predioAtualizado != null) {
            return ResponseEntity.ok(predioAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPredio(@PathVariable UUID id) {
        predioService.deletarPredio(id);
        return ResponseEntity.noContent().build();
    }
}
