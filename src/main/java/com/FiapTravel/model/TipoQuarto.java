package com.FiapTravel.model;

import jakarta.persistence.Entity;
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
public class TipoQuarto {
    @Id
    private UUID idTipoQuarto;
    private String nomeTipoQuarto;
}
