package com.FiapTravel.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FiapTravel.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
//    UserDetails findByLogin(String login);
}
