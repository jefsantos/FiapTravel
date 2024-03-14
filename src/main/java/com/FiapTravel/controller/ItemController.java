package com.FiapTravel.controller;

import com.FiapTravel.model.Item;
import com.FiapTravel.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/itens")
public class ItemController {
    private final ItemService itemService;
    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<Item> criarItem(@RequestBody Item item) {
        Item novoItem = itemService.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoItem);
    }

    @GetMapping
    public ResponseEntity<List<Item>> buscarTodosItens() {
        List<Item> itens = itemService.buscarTodosItens();
        return ResponseEntity.ok(itens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> buscarPorId(@PathVariable UUID id) {
        Optional<Item> itemOptional = itemService.buscarPorId(id);
        return itemOptional.map(quarto -> ResponseEntity.ok().body(quarto))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> atualizarItem(@PathVariable UUID id, @RequestBody Item item) {
        Item itemAtualizado = itemService.atualizarItem(id, item);
        if (itemAtualizado != null) {
            return ResponseEntity.ok(itemAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarItem(@PathVariable UUID id) {
        itemService.deletarItem(id);
        return ResponseEntity.noContent().build();
    }
}