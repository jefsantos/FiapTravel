package com.FiapTravel.repository;

import com.FiapTravel.model.Opcional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OpcionalRepository extends JpaRepository<Opcional, UUID> {
}
