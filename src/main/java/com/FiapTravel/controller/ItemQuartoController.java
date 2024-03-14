package com.FiapTravel.controller;

import com.FiapTravel.model.ItemQuarto;
import com.FiapTravel.model.ItemQuartoId;
import com.FiapTravel.service.ItemQuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itensquartos")
public class ItemQuartoController {
    private final ItemQuartoService itemQuartoService;
    @Autowired
    public ItemQuartoController(ItemQuartoService itemQuartoService) {
        this.itemQuartoService = itemQuartoService;
    }

    @PostMapping
    public ResponseEntity<ItemQuarto> criarItemQuarto(@RequestBody ItemQuarto itemQuarto) {
        ItemQuarto novoItemQuarto = itemQuartoService.save(itemQuarto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoItemQuarto);
    }

    @GetMapping
    public ResponseEntity<List<ItemQuarto>> buscarTodosItensQuartos() {
        List<ItemQuarto> itensQuartos = itemQuartoService.buscarTodosItensQuartos();
        return ResponseEntity.ok(itensQuartos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemQuarto> buscarPorId(@PathVariable ItemQuartoId itemQuartoId) {
        Optional<ItemQuarto> itemQuartoOptional = itemQuartoService.buscarPorId(itemQuartoId);
        return itemQuartoOptional.map(itemQuarto -> ResponseEntity.ok().body(itemQuarto))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemQuarto> atualizarItemQuarto(@PathVariable ItemQuartoId itemQuartoId,
                                                          @RequestBody ItemQuarto itemQuarto) {
        ItemQuarto itemQuartoAtualizado = itemQuartoService.atualizarItemQuarto(itemQuartoId, itemQuarto);
        if (itemQuartoAtualizado != null) {
            return ResponseEntity.ok(itemQuartoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarItemQuarto(@PathVariable ItemQuartoId itemQuartoId) {
        itemQuartoService.deletarItemQuarto(itemQuartoId);
        return ResponseEntity.noContent().build();
    }
}