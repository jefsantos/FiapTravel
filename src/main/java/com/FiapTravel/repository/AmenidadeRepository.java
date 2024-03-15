package com.FiapTravel.repository;

import com.FiapTravel.model.Amenidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AmenidadeRepository extends JpaRepository<Amenidade, UUID> {
}
