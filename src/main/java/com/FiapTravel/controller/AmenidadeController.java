package com.FiapTravel.controller;

import com.FiapTravel.model.Amenidade;
import com.FiapTravel.service.AmenidadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/amenidades")
@Api(value = "Amenidades", tags = "Amenidades")
public class AmenidadeController {

    private final AmenidadeService amenidadeService;

    @Autowired
    public AmenidadeController(AmenidadeService amenidadeService) {
        this.amenidadeService = amenidadeService;
    }

    @ApiOperation(value = "Cria uma nova amenidade")
    @PostMapping
    public ResponseEntity<Amenidade> criarAmenidade(
            @ApiParam(value = "Objeto Amenidade a ser criado", required = true)
            @RequestBody Amenidade amenidade) {
        Amenidade novaAmenidade = amenidadeService.save(amenidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAmenidade);
    }

    @ApiOperation(value = "Busca todas as amenidades")
    @GetMapping
    public ResponseEntity<List<Amenidade>> buscarTodasAmenidades() {
        List<Amenidade> amenidades = amenidadeService.buscarTodasAmenidades();
        return ResponseEntity.ok(amenidades);
    }

    @ApiOperation(value = "Busca uma amenidade pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<Amenidade> buscarPorId(
            @ApiParam(value = "ID da amenidade a ser buscada", required = true)
            @PathVariable UUID id) {
        Optional<Amenidade> amenidadeOptional = amenidadeService.buscarPorId(id);
        return amenidadeOptional.map(amenidade -> ResponseEntity.ok().body(amenidade))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Atualiza uma amenidade")
    @PutMapping("/{id}")
    public ResponseEntity<Amenidade> atualizarAmenidade(
            @ApiParam(value = "ID da amenidade a ser atualizada", required = true)
            @PathVariable UUID id,
            @ApiParam(value = "Objeto Amenidade com as informações atualizadas", required = true)
            @RequestBody Amenidade amenidade) {
        Amenidade amenidadeAtualizada = amenidadeService.atualizarAmenidade(id, amenidade);
        if (amenidadeAtualizada != null) {
            return ResponseEntity.ok(amenidadeAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ApiOperation(value = "Exclui uma amenidade")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAmenidade(
            @ApiParam(value = "ID da amenidade a ser excluída", required = true)
            @PathVariable UUID id) {
        amenidadeService.deletarAmenidade(id);
        return ResponseEntity.noContent().build();
    }
}
