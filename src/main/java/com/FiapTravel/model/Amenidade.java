package com.FiapTravel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Entity
public class Amenidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idAmenidade;
    private String descricaoAmenidade;
}
