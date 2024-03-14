package com.FiapTravel.repository;

import com.FiapTravel.model.Predio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PredioRepository extends JpaRepository<Predio, UUID> {
}
