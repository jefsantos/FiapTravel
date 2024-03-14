package com.FiapTravel.controller;

import com.FiapTravel.model.Opcional;
import com.FiapTravel.service.OpcionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/opcionais")
public class OpcionalController {
    private final OpcionalService opcionalService;
    @Autowired
    public OpcionalController(OpcionalService opcionalService) {
        this.opcionalService = opcionalService;
    }

    @PostMapping
    public ResponseEntity<Opcional> criarOpcional(@RequestBody Opcional opcional) {
        Opcional novoOpcional = opcionalService.save(opcional);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoOpcional);
    }

    @GetMapping
    public ResponseEntity<List<Opcional>> buscarTodosOpcionais() {
        List<Opcional> opcionais = opcionalService.buscarTodosOpcionais();
        return ResponseEntity.ok(opcionais);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Opcional> buscarPorId(@PathVariable UUID id) {
        Optional<Opcional> opcionalOptional = opcionalService.buscarPorId(id);
        return opcionalOptional.map(opcional -> ResponseEntity.ok().body(opcional))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Opcional> atualizarOpcional(@PathVariable UUID id, @RequestBody Opcional opcional) {
        Opcional opcionalAtualizado = opcionalService.atualizarOpcional(id, opcional);
        if (opcionalAtualizado != null) {
            return ResponseEntity.ok(opcionalAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarOpcional(@PathVariable UUID id) {
        opcionalService.deletarOpcional(id);
        return ResponseEntity.noContent().build();
    }
}