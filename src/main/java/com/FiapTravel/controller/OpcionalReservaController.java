package com.FiapTravel.controller;

import com.FiapTravel.model.OpcionalReserva;
import com.FiapTravel.model.OpcionalReservaId;
import com.FiapTravel.service.OpcionalReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/opcionaisreserva")
public class OpcionalReservaController {
    private final OpcionalReservaService opcionalReservaService;

    @Autowired
    public OpcionalReservaController(OpcionalReservaService opcionalReservaService) {
        this.opcionalReservaService = opcionalReservaService;
    }

    @PostMapping
    public ResponseEntity<OpcionalReserva> criarOpcionalReserva(@RequestBody OpcionalReserva opcionalReserva) {
        OpcionalReserva novoOpcionalReserva = opcionalReservaService.save(opcionalReserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoOpcionalReserva);
    }

    @GetMapping
    public ResponseEntity<List<OpcionalReserva>> buscarTodosOpcionaisReserva() {
        List<OpcionalReserva> opcionaisReserva = opcionalReservaService.buscarTodosOpcionaisReserva();
        return ResponseEntity.ok(opcionaisReserva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OpcionalReserva> buscarPorId(@PathVariable OpcionalReservaId id) {
        Optional<OpcionalReserva> opcionalReservaOptional =
                opcionalReservaService.buscarPorId(id);
        return opcionalReservaOptional.map(opcionalReserva -> ResponseEntity.ok().body(opcionalReserva))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OpcionalReserva> atualizarOpcionalReserva(@PathVariable OpcionalReservaId id,
                                                                    @RequestBody OpcionalReserva opcionalReserva) {
        OpcionalReserva opcionalReservaAtualizado =
                opcionalReservaService.atualizarOpcionalReserva(id, opcionalReserva);
        if (opcionalReservaAtualizado != null) {
            return ResponseEntity.ok(opcionalReservaAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarOpcionalReserva(@PathVariable OpcionalReservaId id) {
        opcionalReservaService.deletarOpcionalReserva(id);
        return ResponseEntity.noContent().build();
    }
}