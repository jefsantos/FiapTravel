package com.FiapTravel.controller;

import com.FiapTravel.model.OpcionalLocalidade;
import com.FiapTravel.model.OpcionalLocalidadeId;
import com.FiapTravel.services.OpcionalLocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/opcionaislocalidades")
public class OpcionalLocalidadeController {
    private final OpcionalLocalidadeService opcionalLocalidadeService;
    @Autowired
    public OpcionalLocalidadeController(OpcionalLocalidadeService opcionalLocalidadeService) {
        this.opcionalLocalidadeService = opcionalLocalidadeService;
    }

    @PostMapping
    public ResponseEntity<OpcionalLocalidade> criarOpcionalLocalidade(@RequestBody OpcionalLocalidade opcionalLocalidade) {
        OpcionalLocalidade novoOpcionalLocalidade = opcionalLocalidadeService.save(opcionalLocalidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoOpcionalLocalidade);
    }

    @GetMapping
    public ResponseEntity<List<OpcionalLocalidade>> buscarTodosOpcionaisLocalidades() {
        List<OpcionalLocalidade> opcionaisLocalidades = opcionalLocalidadeService.buscarTodosOpcionaisLocalidades();
        return ResponseEntity.ok(opcionaisLocalidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OpcionalLocalidade> buscarPorId(@PathVariable OpcionalLocalidadeId opcionalLocalidadeId) {
        Optional<OpcionalLocalidade> opcionalLocalidadeOptional =
                opcionalLocalidadeService.buscarPorId(opcionalLocalidadeId);
        return opcionalLocalidadeOptional.map(opcionalLocalidade -> ResponseEntity.ok().body(opcionalLocalidade))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OpcionalLocalidade> atualizarOpcionalLocalidade(@PathVariable OpcionalLocalidadeId opcionalLocalidadeId,
                                                          @RequestBody OpcionalLocalidade opcionalLocalidade) {
        OpcionalLocalidade opcionalLocalidadeAtualizado =
                opcionalLocalidadeService.atualizarOpcionalLocalidade(opcionalLocalidadeId, opcionalLocalidade);
        if (opcionalLocalidadeAtualizado != null) {
            return ResponseEntity.ok(opcionalLocalidadeAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarOpcionalLocalidade(@PathVariable OpcionalLocalidadeId opcionalLocalidadeId) {
        opcionalLocalidadeService.deletarOpcionalLocalidade(opcionalLocalidadeId);
        return ResponseEntity.noContent().build();
    }
}