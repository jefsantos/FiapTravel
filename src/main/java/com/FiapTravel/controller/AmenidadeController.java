package com.FiapTravel.controller;

import com.FiapTravel.model.Amenidade;
import com.FiapTravel.service.AmenidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/amenidades")
public class AmenidadeController {

    private final AmenidadeService amenidadeService;

    @Autowired
    public AmenidadeController(AmenidadeService amenidadeService) {
        this.amenidadeService = amenidadeService;
    }

    @PostMapping
    public ResponseEntity<Amenidade> criarAmenidade(@RequestBody Amenidade amenidade) {
        Amenidade novaAmenidade = amenidadeService.save(amenidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAmenidade);
    }

    @GetMapping
    public ResponseEntity<List<Amenidade>> buscarTodasAmenidades() {
        List<Amenidade> amenidades = amenidadeService.buscarTodasAmenidades();
        return ResponseEntity.ok(amenidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Amenidade> buscarPorId(@PathVariable UUID id) {
        Optional<Amenidade> amenidadeOptional = amenidadeService.buscarPorId(id);
        return amenidadeOptional.map(amenidade -> ResponseEntity.ok().body(amenidade))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Amenidade> atualizarAmenidade(@PathVariable UUID id, @RequestBody Amenidade amenidade) {
        Amenidade amenidadeAtualizada = amenidadeService.atualizarAmenidade(id, amenidade);
        if (amenidadeAtualizada != null) {
            return ResponseEntity.ok(amenidadeAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAmenidade(@PathVariable UUID id) {
        amenidadeService.deletarAmenidade(id);
        return ResponseEntity.noContent().build();
    }
}