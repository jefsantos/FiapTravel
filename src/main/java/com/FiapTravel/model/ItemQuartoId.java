package com.FiapTravel.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ItemQuartoId implements Serializable {

    private UUID idQuarto;
    private UUID idItem;

}
