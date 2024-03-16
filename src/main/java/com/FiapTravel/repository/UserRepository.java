package com.FiapTravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FiapTravel.model.User;

public interface UserRepository extends JpaRepository<User, String> {
//    UserDetails findByLogin(String login);
}
