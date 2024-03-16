package com.FiapTravel.controller;

import com.FiapTravel.model.Localidade;
import com.FiapTravel.service.LocalidadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/localidades")
@Api(tags = "Localidades", description = "Operações relacionadas a localidades")
public class LocalidadeController {

    private final LocalidadeService localidadeService;

    @Autowired
    public LocalidadeController(LocalidadeService localidadeService) {
        this.localidadeService = localidadeService;
    }

    @PostMapping
    @ApiOperation(value = "Criar uma nova localidade")
    public ResponseEntity<Localidade> criarLocalidade(@RequestBody Localidade localidade) {
        Localidade novaLocalidade = localidadeService.save(localidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaLocalidade);
    }

    @GetMapping
    @ApiOperation(value = "Buscar todas as localidades")
    public ResponseEntity<List<Localidade>> buscarTodasLocalidades() {
        List<Localidade> localidades = localidadeService.buscarTodasLocalidades();
        return ResponseEntity.ok(localidades);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar uma localidade pelo ID")
    public ResponseEntity<Localidade> buscarPorId(@PathVariable UUID id) {
        Optional<Localidade> localidadeOptional = localidadeService.buscarPorId(id);
        return localidadeOptional.map(localidade -> ResponseEntity.ok().body(localidade))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualizar uma localidade")
    public ResponseEntity<Localidade> atualizarLocalidade(@PathVariable UUID id, @RequestBody Localidade localidade) {
        Localidade localidadeAtualizada = localidadeService.atualizarLocalidade(id, localidade);
        if (localidadeAtualizada != null) {
            return ResponseEntity.ok(localidadeAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletar uma localidade")
    public ResponseEntity<Void> deletarLocalidade(@PathVariable UUID id) {
        localidadeService.deletarLocalidade(id);
        return ResponseEntity.noContent().build();
    }
}
