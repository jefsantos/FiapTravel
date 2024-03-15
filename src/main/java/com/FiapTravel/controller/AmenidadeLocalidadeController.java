package com.FiapTravel.controller;

import com.FiapTravel.model.AmenidadeLocalidade;
import com.FiapTravel.model.AmenidadeLocalidadeId;
import com.FiapTravel.service.AmenidadeLocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/amenidadeslocalidades")
public class AmenidadeLocalidadeController {

    private final AmenidadeLocalidadeService amenidadeLocalidadeService;

    @Autowired
    public AmenidadeLocalidadeController(AmenidadeLocalidadeService amenidadeLocalidadeService) {
        this.amenidadeLocalidadeService = amenidadeLocalidadeService;
    }

    @PostMapping
    public ResponseEntity<AmenidadeLocalidade> criarAmenidadeLocalidade(@RequestBody AmenidadeLocalidade amenidadeLocalidade) {
        AmenidadeLocalidade novaAmenidadeLocalidade = amenidadeLocalidadeService.save(amenidadeLocalidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAmenidadeLocalidade);
    }

    @GetMapping
    public ResponseEntity<List<AmenidadeLocalidade>> buscarTodasAmenidadesLocalidades() {
        List<AmenidadeLocalidade> amenidadesLocalidades = amenidadeLocalidadeService.buscarTodasAmenidadesLocalidades();
        return ResponseEntity.ok(amenidadesLocalidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AmenidadeLocalidade> buscarPorId(@PathVariable AmenidadeLocalidadeId id) {
        Optional<AmenidadeLocalidade> amenidadeLocalidadeOptional = amenidadeLocalidadeService.buscarPorId(id);
        return amenidadeLocalidadeOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AmenidadeLocalidade> atualizarAmenidadeLocalidade(@PathVariable AmenidadeLocalidadeId id,
                                                                            @RequestBody AmenidadeLocalidade amenidadeLocalidade) {
        AmenidadeLocalidade amenidadeLocalidadeAtualizada = amenidadeLocalidadeService.atualizarAmenidadeLocalidade(id, amenidadeLocalidade);
        if (amenidadeLocalidadeAtualizada != null) {
            return ResponseEntity.ok(amenidadeLocalidadeAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAmenidadeLocalidade(@PathVariable AmenidadeLocalidadeId id) {
        amenidadeLocalidadeService.deletarAmenidadeLocalidade(id);
        return ResponseEntity.noContent().build();
    }
}