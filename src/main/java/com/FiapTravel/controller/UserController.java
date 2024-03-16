package com.FiapTravel.controller;

import com.FiapTravel.model.User;
import com.FiapTravel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> criarUser(@RequestBody User user) {
        User novoUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> buscarTodosUsers() {
        List<User> users = userService.buscarTodosUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> buscarPorId(@PathVariable UUID id) {
        Optional<User> userOptional = userService.buscarPorId(id);
        return userOptional.map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> atualizarUser(@PathVariable UUID id, @RequestBody User user) {
        User userAtualizado = userService.atualizarUser(id, user);
        if (userAtualizado != null) {
            return ResponseEntity.ok(userAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUser(@PathVariable UUID id) {
        userService.deletarUser(id);
        return ResponseEntity.noContent().build();
    }
}