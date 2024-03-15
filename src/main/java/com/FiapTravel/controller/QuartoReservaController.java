package com.FiapTravel.controller;

import com.FiapTravel.model.QuartoReserva;
import com.FiapTravel.model.QuartoReservaId;
import com.FiapTravel.service.QuartoReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quartosreservas")
public class QuartoReservaController {

    private final QuartoReservaService quartoReservaService;

    @Autowired
    public QuartoReservaController(QuartoReservaService quartoReservaService) {
        this.quartoReservaService = quartoReservaService;
    }

    @PostMapping
    public ResponseEntity<QuartoReserva> criarQuartoReserva(@RequestBody QuartoReserva quartoReserva) {
        QuartoReserva novaQuartoReserva = quartoReservaService.save(quartoReserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaQuartoReserva);
    }

    @GetMapping
    public ResponseEntity<List<QuartoReserva>> buscarTodasQuartoReservas() {
        List<QuartoReserva> quartosReservas = quartoReservaService.buscarTodasQuartoReservas();
        return ResponseEntity.ok(quartosReservas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuartoReserva> buscarPorId(@PathVariable QuartoReservaId id) {
        Optional<QuartoReserva> quartoReservaOptional = quartoReservaService.buscarPorId(id);
        return quartoReservaOptional.map(quartoReserva -> ResponseEntity.ok().body(quartoReserva))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuartoReserva> atualizarQuartoReserva(@PathVariable QuartoReservaId id,
                                                                @RequestBody QuartoReserva quartoReserva) {
        QuartoReserva quartoReservaAtualizado = quartoReservaService.atualizarQuartoReserva(id, quartoReserva);
        if (quartoReservaAtualizado != null) {
            return ResponseEntity.ok(quartoReservaAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarQuartoReserva(@PathVariable QuartoReservaId id) {
        quartoReservaService.deletarQuartoReserva(id);
        return ResponseEntity.noContent().build();
    }
}