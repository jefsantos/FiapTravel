package com.FiapTravel.controller;

import com.FiapTravel.model.Reserva;
import com.FiapTravel.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<Reserva> criarReserva(@RequestBody Reserva reserva) {
        Reserva novaReserva = reservaService.save(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaReserva);
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> buscarTodasReservas() {
        List<Reserva> reservas = reservaService.buscarTodasReservas();
        return ResponseEntity.ok(reservas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> buscarPorId(@PathVariable UUID id) {
        Optional<Reserva> reservaOptional = reservaService.buscarPorId(id);
        return reservaOptional.map(reserva -> ResponseEntity.ok().body(reserva))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> atualizarReserva(@PathVariable UUID id, @RequestBody Reserva reserva) {
        Reserva reservaAtualizada = reservaService.atualizarReserva(id, reserva);
        if (reservaAtualizada != null) {
            return ResponseEntity.ok(reservaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarReserva(@PathVariable UUID id) {
        reservaService.deletarReserva(id);
        return ResponseEntity.noContent().build();
    }
}