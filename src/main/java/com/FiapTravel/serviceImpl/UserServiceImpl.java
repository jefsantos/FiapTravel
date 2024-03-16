package com.FiapTravel.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FiapTravel.model.User;
import com.FiapTravel.repository.UserRepository;
import com.FiapTravel.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        if (user == null) {
            throw new IllegalArgumentException("O usuário não pode ser nulo.");
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> buscarTodosUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> buscarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID do usuário não pode ser nulo.");
        }
        return userRepository.findById(id);
    }

    @Override
    public User atualizarUser(UUID id, User user) {
        if (id == null || user == null) {
            throw new IllegalArgumentException("O ID e o usuário não podem ser nulos.");
        }
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            user.setId(id);
            return userRepository.save(user);
        } else {
            throw new IllegalArgumentException("Usuário não encontrado para o ID fornecido: " + id);
        }
    }

    @Override
    public void deletarUser(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID do usuário não pode ser nulo.");
        }
        userRepository.deleteById(id);
    }
}